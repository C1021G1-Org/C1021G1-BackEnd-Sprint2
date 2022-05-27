package com.example.carparkingmanagementbe.dto;
import com.example.carparkingmanagementbe.model.Ward;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import com.example.carparkingmanagementbe.model.Ward;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


import javax.validation.constraints.*;


public class CustomerDto implements Validator {
    private static final String REGEX_NAME = "^[a-zA-ZàáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợởỡùúụủũưừứựửữỳýỵỷỹđÀÁẠẢÃÂẦẤẬẨẪĂẰẮẶẲẴÈÉẸẺẼÊỀẾỆỂỄÌÍỊỈĨÒÓỌỎÕÔỒỐỘỔỖƠỜỚỢỞỠÙÚỤỦŨƯỪỨỰỬỮỲÝỴỶỸĐ]+(\\s[a-zA-ZàáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợởỡùúụủũưừứựửữỳýỵỷỹđÀÁẠẢÃÂẦẤẬẨẪĂẰẮẶẲẴÈÉẸẺẼÊỀẾỆỂỄÌÍỊỈĨÒÓỌỎÕÔỒỐỘỔỖƠỜỚỢỞỠÙÚỤỦŨƯỪỨỰỬỮỲÝỴỶỸĐ]+)*$";
    private static final String REGEX_PHONE = "^([0-9])*$";
    @NotNull(message = "Trường này không thể để trống")
    @Pattern(regexp = "((KH-|kh-)\\d{3})", message = "Mã khách hàng phải là KH-XXX")
    private String code;
    @Size(max = 40, message = "Tối đa 40 kí tự!")
    @Pattern(regexp = REGEX_NAME, message = "Vui lòng nhập đúng tên của bạn!")
    @NotEmpty(message = "Trường này không thể để trống.")
    private String name;
    @NotBlank(message = "Trường này không thể để trống.")
    private String birthday;
    @Size(min = 9,max = 12, message = "Nhập tối đa 9 đến 12 số.")
    @NotBlank(message = "Vui lòng nhập CMND/CCCD")
    private String idCard;
    @Size(max = 40, message = "Tối đa 40 kí tự!")
    @NotBlank(message = "Trường này không thể để trống.")
    @Email(message = "Phải đúng định dạng email ví dụ: abc@gmail.com")
    private String email;
    @Size(min = 10,max = 13, message = "Tối đa 13 số!")
    @Pattern(regexp = REGEX_PHONE, message = "Vui lòng nhập đúng số điện thoại!")
    @NotBlank(message = "Trường này không thể để trống.")
    private String phone;
    @NotBlank(message = "Trường này không thể để trống.")
    private String address;
    private Boolean gender;
    private Boolean delFlag;
    private Long ward;

    public CustomerDto() {
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
