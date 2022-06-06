package com.example.carparkingmanagementbe.controller;

import com.example.carparkingmanagementbe.dto.CreateTicketDto;
import com.example.carparkingmanagementbe.dto.EmptyLocation;
import com.example.carparkingmanagementbe.dto.PathImage;
import com.example.carparkingmanagementbe.dto.TicketDto;
import com.example.carparkingmanagementbe.model.Car;
import com.example.carparkingmanagementbe.model.Location;
import com.example.carparkingmanagementbe.model.Ticket;
import com.example.carparkingmanagementbe.model.TicketType;
import com.example.carparkingmanagementbe.service.ICarService;
import net.sourceforge.tess4j.Tesseract;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.carparkingmanagementbe.dto.ticket.TicketDtoSearch;
import com.example.carparkingmanagementbe.service.ITicketService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.validation.Valid;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/ticket")
public class TicketController {
    private static final String FILE7 = "E:\\Project-Flight\\sprint 2\\C1021G1-BackEnd-Sprint2\\car-parking-management-be\\src\\main\\resources\\static\\test2.jpg";

    @Autowired
    private ITicketService ticketService;

    @Autowired
    private ICarService carService;




    @GetMapping("/emptyLocation")
    public ResponseEntity<EmptyLocation> emptyLocation() {
        EmptyLocation emptyLocation = ticketService.emptyLocation();
        System.out.println(emptyLocation);
        return new ResponseEntity<>(emptyLocation,HttpStatus.OK);
    }


    @PostMapping("/create")
    public ResponseEntity<?> createTicket(@Valid @RequestBody CreateTicketDto createTicketDto) {
        String carPlate = createTicketDto.getCarPlate();
        boolean checkPlate = true;
        List<Ticket> ticketList =ticketService.listTicket();
        for(Ticket ticket : ticketList){
            if(ticket.getCar().getCarPlate().equals(carPlate)){
                checkPlate =false;
                break;
            }
        }
        if(checkPlate){
            List<Car> carList = carService.findAll();
            Long idCar = -1L;
            for (Car car1: carList){
                if(car1.getCarPlate().equals(carPlate)){
                    idCar = car1.getId();
                    break;
                }
            }
            Car car = carService.findById(idCar);

            if(createTicketDto.getIdTicketType() == 1){
                createTicketDto.setSumPrice(50000D);
            }else {
                createTicketDto.setSumPrice(1400000D);
            }

            Location location = new Location();
            location.setId(createTicketDto.getIdLocation());
            TicketType ticketType = new TicketType();
            ticketType.setId(createTicketDto.getIdTicketType());
            Ticket ticket = new Ticket();
            createTicketDto.setChecking(false);
            createTicketDto.setDelFlag(true);
            ticket.setCar(car);
            ticket.setLocation(location);
            ticket.setTicketType(ticketType);
            BeanUtils.copyProperties(createTicketDto, ticket);
            ticket.setIsDoing(false);
            ticketService.createTicket(ticket);
        }

        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

    @PostMapping("/updateTime")
    public ResponseEntity<?> update(@Valid @RequestBody CreateTicketDto createTicketDto) {
        List<Ticket> ticketList = ticketService.listTicket();
        for(Ticket ticket:ticketList){
            if(ticket.getCar().getCarPlate().equals(createTicketDto.getCarPlate())){
                Ticket ticket1 = new Ticket();
                BeanUtils.copyProperties(ticket,ticket1);
                ticket1.setTimeOut(createTicketDto.getTimeOut());
                ticket1.setImgCarOut(ticket.getImgCarOut());
                ticketService.save(ticket1);
            }
        }
//        Car car = carService.findById(createTicketDto.getCar());
//        Location location = new Location();
//        location.setId(createTicketDto.getIdLocation());
//        TicketType ticketType = new TicketType();
//        ticketType.setId(createTicketDto.getIdTicketType());
//        Ticket ticket = new Ticket();
//        createTicketDto.setChecking(false);
//        createTicketDto.setDelFlag(true);
//        ticket.setCar(car);
//        ticket.setLocation(location);
//        ticket.setTicketType(ticketType);
//        BeanUtils.copyProperties(createTicketDto, ticket);
//        ticket.setIsDoing(false);
//        ticketService.updateTicket(ticket);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

//    @PatchMapping("/isChecking")
//    public ResponseEntity<?> isChecking (Boolean isChecking){
//        ticketService.checking(isChecking);
//        return new ResponseEntity<>(HttpStatus.CREATED);
//    }

    @PostMapping("/checkImage")
    public ResponseEntity<?> readImage(@RequestBody PathImage file) throws Exception {
        String fullTess = changeFile("C:\\Users\\ACER\\Desktop\\xe\\"+file.getPath());
        return new ResponseEntity<>(new PathImage(fullTess), HttpStatus.OK);
    }

    public String changeFile(String file) throws Exception {

        Path target = Paths.get("E:\\Project-Flight\\sprint 2\\C1021G1-BackEnd-Sprint2\\car-parking-management-be\\src\\main\\resources\\static\\test2.jpg");

        File file1 = new File(file);
        BufferedImage original = ImageIO.read(file1);
        BufferedImage newBufferedImage = new BufferedImage(
                600,
                600,
                BufferedImage.TYPE_BYTE_BINARY);
        newBufferedImage.createGraphics()
                .drawImage(original,
                        0,
                        0,
                        original.getWidth(),
                        original.getHeight(),
                        Color.BLACK,
                        null);
        ImageIO.write(newBufferedImage, "jpg", target.toFile());
//        changeImage(FILE);
        Tesseract tesseract = new Tesseract();
        tesseract.setLanguage("spa");
        tesseract.setDatapath("E:\\Project-Flight\\sprint 2\\C1021G1-BackEnd-Sprint2\\car-parking-management-be\\src\\main\\resources\\tessdata");

        String fullTess = tesseract.doOCR(new File(FILE7));
        System.out.println(fullTess);
        String[] arrayString = fullTess.split("");
        String result = "";
        for (String item : arrayString) {
            if (item.trim().length() > 0) {
                result += item;
            }
        }
        return result;
//        Ocr.setUp(); // one time setup
//        Ocr ocr = new Ocr(); // create a new OCR engine
//        ocr.startEngine("eng", Ocr.SPEED_FASTEST); // English
//        String s = ocr.recognize(new File[]{new File(FILE7)}
//                , Ocr.RECOGNIZE_TYPE_TEXT, Ocr.OUTPUT_FORMAT_PLAINTEXT);
//        System.out.println("Result: " + s);
//        ocr.stopEngine();
    }

    @GetMapping("/check")
    public ResponseEntity<Page<Ticket>> getAllTicket(@RequestParam(defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<Ticket> ticketPage = ticketService.findAll(pageable);
        if (ticketPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(ticketPage, HttpStatus.OK);
    }

    @PostMapping("/search")
    public ResponseEntity<Page<Ticket>> getSearchTicketPage(@RequestBody TicketDtoSearch ticketDtoSearch, @RequestParam(defaultValue = "0") int page) {
        PageRequest pageRequest = PageRequest.of(page, 5);
        Page<Ticket> ticketPage = ticketService.searchTicketPage(ticketDtoSearch.getFloor(),
                ticketDtoSearch.getTicketTypeName(), ticketDtoSearch.getEndDate(), ticketDtoSearch.getNameCustomer(),
                ticketDtoSearch.getPhoneCustomer(), pageRequest);
        if (ticketPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(ticketPage, HttpStatus.OK);

    }

    @PatchMapping("/delete/{id}")
    public ResponseEntity<?> deleteTicket(@PathVariable Long id) {

        Ticket ticket = ticketService.getTicketById(id);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String endDate = ticket.getEndDate();
        LocalDate current = LocalDate.now();
        LocalDate changeEndDay = LocalDate.parse(endDate, formatter);
        Long betweenDay = ChronoUnit.DAYS.between(changeEndDay, current);
        if (betweenDay >= 0) {
            if (ticket.getTimeOut() == null) {
                Map<String, String> map = new HashMap<>();
                map.put("messageEros", "xe vẩn còn bên trong nên không thể xóa hihi");
                return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
            } else {
                DateTimeFormatter formatterInOut = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
                String timeIn = ticket.getTimeIn();
                String timeOut = ticket.getTimeOut();
                String changeTimeIn = String.format(timeIn, formatterInOut);
                String changeTimeOut = String.format(timeOut, formatterInOut);
                int check = changeTimeIn.compareTo(changeTimeOut);
                if (check < 0) {
                    ticketService.deleteTicketByDel(ticket.getId());
                    return new ResponseEntity<>(check, HttpStatus.OK);
                } else {
                    Map<String, String> map = new HashMap<>();
                    map.put("messageEros", "xe vẩn còn bên trong nên không thể xóa");
                    return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
                }
            }
        } else {
            Map<String, String> map = new HashMap<>();
            map.put("messageEros", "Vẩn còn hạng");
            return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
        }
    }

// tam controller end
//long begin

    @GetMapping("/edit/{id}")
    public ResponseEntity<Ticket> getTicketById(@PathVariable Long id) {
        Ticket ticket = ticketService.findTicketById(id);
        if (ticket == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(ticket, HttpStatus.OK);
    }

    @PatchMapping("/update")
    public ResponseEntity<?> updateTicket(@Valid @RequestBody TicketDto ticketDto, BindingResult bindingResult) {
        new TicketDto().validate(ticketDto, bindingResult);
        Map<String, String> errorList = new HashMap<>();
        if (bindingResult.hasErrors()) {
            for (ObjectError objectError : bindingResult.getAllErrors()) {
                String errorName = ((FieldError) objectError).getField();
                String error = objectError.getDefaultMessage();
                errorList.put(errorName, error);
            }
            return new ResponseEntity<>(errorList, HttpStatus.BAD_REQUEST);
        } else {
            Ticket ticket = ticketService.findTicketById(ticketDto.getId());
            if (ticket == null) {
                Map<String, String> map = new HashMap<>();
                map.put("messageEros", "không tìm thấy ticket");
                return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
            } else {
                ticketService.updateTicket(ticketDto.getLocation(), ticketDto.getSumPrice(), ticketDto.getTicketType(), ticketDto.getEndDate(), ticketDto.getId());

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                String inputBirthday = ticketDto.getEndDate();
                LocalDate birthDay = LocalDate.parse(inputBirthday, formatter);
                LocalDate current = LocalDate.now();
                long betweenDate = ChronoUnit.DAYS.between(current, birthDay);
                Map<String, String> map = new HashMap<>();
                map.put("time", "thời gian chenh lệch: " + betweenDate);
                return new ResponseEntity<>(map, HttpStatus.OK);
            }


        }
    }
// longLT End}


}

