package com.example.carparkingmanagementbe.dto;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;


public class CustomerDto implements Validator {
    private static final String REGEX_NAME = "^[a-zA-ZàáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợởỡùúụủũưừứựửữỳýỵỷỹđÀÁẠẢÃÂẦẤẬẨẪĂẰẮẶẲẴÈÉẸẺẼÊỀẾỆỂỄÌÍỊỈĨÒÓỌỎÕÔỒỐỘỔỖƠỜỚỢỞỠÙÚỤỦŨƯỪỨỰỬỮỲÝỴỶỸĐ]+(\\s[a-zA-ZàáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợởỡùúụủũưừứựửữỳýỵỷỹđÀÁẠẢÃÂẦẤẬẨẪĂẰẮẶẲẴÈÉẸẺẼÊỀẾỆỂỄÌÍỊỈĨÒÓỌỎÕÔỒỐỘỔỖƠỜỚỢỞỠÙÚỤỦŨƯỪỨỰỬỮỲÝỴỶỸĐ]+)*$";
    private static final String REGEX_PHONE = "^(0[3|7|8|5|9])+([0-9]{8,9})$";
    private String code;
    private Long id;
    @Size(min = 5,max = 40,message = "Tên phải từ 5-40 kí tự.")
    @Pattern(regexp = REGEX_NAME, message = "Vui lòng nhập đúng tên của bạn!")
    @NotEmpty(message = "Trường này không thể để trống.")
    @NotNull(message = "Trường này không thể để trống.")
    private String name;

    @NotBlank(message = "Trường này không thể để trống.")
    private String birthday;

    @Size(min = 9,max = 12, message = "Nhập tối đa 9 đến 12 số.")
    @NotBlank(message = "Vui lòng nhập CMND/CCCD")
    @Pattern(regexp = "^[0-9]{9,12}$", message = "CMND/CCCD phải đúng quy định.")
    private String idCard;
    @Size(max = 40, message = "Tối đa 40 kí tự!")
    @NotBlank(message = "Trường này không thể để trống.")
    @Email(message = "Phải đúng định dạng email.Ví dụ: abc@gmail.com")
    private String email;

    @Size(min = 9,max = 10, message = "Số điện thoại từ 9 tới 10 số.")
    @Pattern(regexp = REGEX_PHONE, message = "Vui lòng nhập đúng số điện thoại!")
    @NotBlank(message = "Trường này không thể để trống.")
    private String phone;
    @Size(max = 40,message = "Tối đa 40 kí tự.")
    @NotBlank(message = "Trường này không thể để trống.")
    private String address;

    private Boolean gender;

    private Boolean delFlag;

    private Long ward;
    private Long idAccount;

    public CustomerDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public Boolean getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Boolean delFlag) {
        this.delFlag = delFlag;
    }

    public Long getWard() {
        return ward;
    }

    public void setWard(Long ward) {
        this.ward = ward;
    }

    public Long getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(Long idAccount) {
        this.idAccount = idAccount;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        CustomerDto customerDto = (CustomerDto) target;
        String inputBirthday = customerDto.getBirthday();
        if (inputBirthday != null) {
            LocalDate birthDay = LocalDate.parse(inputBirthday, formatter);
            LocalDate current = LocalDate.now();
            int betweenDate =  Period.between(birthDay, current).getYears();
            if(betweenDate<18){
                errors.rejectValue("birthday","","Khách hàng phải lớn hơn 18 tuổi.");
            }
        }

    }
}
