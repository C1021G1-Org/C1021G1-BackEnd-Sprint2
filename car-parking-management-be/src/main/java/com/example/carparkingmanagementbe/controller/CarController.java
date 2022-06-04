package com.example.carparkingmanagementbe.controller;
import com.example.carparkingmanagementbe.dto.CarDto;
import com.example.carparkingmanagementbe.model.Car;
import com.example.carparkingmanagementbe.model.CarType;
import com.example.carparkingmanagementbe.service.ICarService;
import com.example.carparkingmanagementbe.service.ICarTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/car")
public class CarController {
    @Autowired
    private ICarService carService;

    @Autowired
    private ICarTypeService carTypeService;

    @PostMapping("/create")
    public ResponseEntity<?> createCar(@Valid @RequestBody CarDto carDto) {
        int code = (int) Math.floor((Math.random()*899) + 100);
        String codeRandom = String.valueOf(code);
        carDto.setCode("XE-" + codeRandom);
        carService.createCar(carDto);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    //    tronghd validate dữ liệu thêm mới
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
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

    @GetMapping("/carType-list")
    public ResponseEntity<List<CarType>> getAllCarType() {
        if (carTypeService.findAll().isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(carTypeService.findAll(), HttpStatus.OK);
        }
    }

//    Bảo hiển thị xe theo id customer
    @GetMapping("/detail/{id}")
    public ResponseEntity<List<Car>> findCarByCustomerId(@PathVariable Long id) {
        List<Car> carList = carService.selectCar(id);
        if (carList == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(carList, HttpStatus.OK);

    }
//    Bảo lấy xe nếu null id_customer
    @GetMapping("/list-car")
    public ResponseEntity<List<Car>> findCarByIdCustomerNull(){
        List<Car> carLists = carService.findCarByIdCustomerNull();
        if (carLists == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(carLists,HttpStatus.OK);
    }
}
