package com.example.carparkingmanagementbe.controller;
import com.example.carparkingmanagementbe.dto.CarDto;
import com.example.carparkingmanagementbe.dto.CarPlateDto;
import com.example.carparkingmanagementbe.dto.CarTicketDto;
import com.example.carparkingmanagementbe.dto.ticket.TicketCar;
import com.example.carparkingmanagementbe.model.Car;
import com.example.carparkingmanagementbe.model.Customer;
import com.example.carparkingmanagementbe.model.Ticket;
import com.example.carparkingmanagementbe.service.ICarService;
import com.example.carparkingmanagementbe.service.ICarTypeService;
import com.example.carparkingmanagementbe.service.ICustomerService;
import com.example.carparkingmanagementbe.service.ITicketService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@CrossOrigin
@RestController
@RequestMapping("/api/car")
public class CarController {
    @Autowired
    private ICustomerService customerService;

    @Autowired
    private ITicketService ticketService;

    @Autowired
    private ICarService carService;

    @Autowired
    private ICarTypeService carTypeService;

    @PostMapping("/create")
    public ResponseEntity<?> createCar(@Valid @RequestBody CarDto carDto) {
        carService.createCar(carDto);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    //    tronghd validate dữ liệu thêm mới
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

    @GetMapping("/list")
    public ResponseEntity<List<Car>> getAll() {
        if (carService.findAll().isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(carService.findAll(), HttpStatus.OK);
        }
    }

    //SonDCM findCardModal
    @GetMapping("/findModal")
    public ResponseEntity<List<CarPlateDto>> findCarModal(@RequestParam(required = false, value = "") String name,
                                                          @RequestParam(required = false, value = "") String phone ,
                                                          @RequestParam(required = false, value = "") String plate){
        List<CarPlateDto> carList = carService.findCarModal(name, phone, plate);
        if(carList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(carList, HttpStatus.OK);
        }
    }
    @GetMapping("/chooseCar")
    public ResponseEntity<?> chooseCar(@RequestParam(required = false, value = "") String plate){
        List<Ticket> ticketList = ticketService.listTicket();

        Car car = new Car();
        Long idCustomer = 0L;
        Customer customer = new Customer();
        TicketCar ticketCar = new TicketCar();
        List<TicketCar> ticketCarList = new ArrayList<>();

        if (ticketList == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
//            for(Ticket ticket: ticketList){
//                if(ticket.getCar().getCarPlate().equals(plate)){
//                    List<Ticket> tickets = new ArrayList<>();
//                    tickets.add(ticket);
//                    return new  ResponseEntity<>(tickets,HttpStatus.OK);
//                }
//            }
            for (Ticket ticket: ticketList){
                Long idCar = ticket.getCar().getId();
                car = carService.findById(idCar);
                if (car.getCarPlate().equals(plate)){
                    return new ResponseEntity<>(carService.chooseCar(plate),HttpStatus.OK);
                }
            }
            List<Car> carList = carService.findAll();
            for (Car car1 : carList){
                if (car1.getCarPlate().equals(plate)){
                    car = car1;
                    idCustomer = car1.getCustomer().getId();
                    break;
                }
            }
            if (idCustomer > 0){
                customer = customerService.findCustomerById(idCustomer).get();
                ticketCar.setCarCompany(car.getCarCompany());
                ticketCar.setCarPlate(car.getCarPlate());
                ticketCar.setCarName(car.getName());
                ticketCar.setCustomerName(customer.getName());
                ticketCar.setCustomerPhone(customer.getPhone());
//                ticketCar.setNameLocation(carService.chooseCar(plate).get(0).getnameLocation());
            }
            ticketCarList.add(ticketCar);
            return new ResponseEntity<>(ticketCarList,HttpStatus.OK);

        }

    }
}
