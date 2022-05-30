package com.example.carparkingmanagementbe.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class EmployeeDto {
    private static final String REGEX_NAME = "^([a-zA-ZàáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợởỡùúụủũưừứựửữỳýỵỷỹđÀÁẠẢÃÂẦẤẬẨẪĂẰẮẶẲẴÈÉẸẺẼÊỀẾỆỂỄÌÍỊỈĨÒÓỌỎÕÔỒỐỘỔỖƠỜỚỢỞỠÙÚỤỦŨƯỪỨỰỬỮỲÝỴỶỸĐ]+(\\s[a-zA-ZàáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợởỡùúụủũưừứựửữỳýỵỷỹđÀÁẠẢÃÂẦẤẬẨẪĂẰẮẶẲẴÈÉẸẺẼÊỀẾỆỂỄÌÍỊỈĨÒÓỌỎÕÔỒỐỘỔỖƠỜỚỢỞỠÙÚỤỦŨƯỪỨỰỬỮỲÝỴỶỸĐ]+)*){6,40}$";
    private static final String REGEX_ADDRESS = "^([0-9a-zA-ZàáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợởỡùúụủũưừứựửữỳýỵỷỹđÀÁẠẢÃÂẦẤẬẨẪĂẰẮẶẲẴÈÉẸẺẼÊỀẾỆỂỄÌÍỊỈĨÒÓỌỎÕÔỒỐỘỔỖƠỜỚỢỞỠÙÚỤỦŨƯỪỨỰỬỮỲÝỴỶỸĐ]+(\\s[a-zA-ZàáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợởỡùúụủũưừứựửữỳýỵỷỹđÀÁẠẢÃÂẦẤẬẨẪĂẰẮẶẲẴÈÉẸẺẼÊỀẾỆỂỄÌÍỊỈĨÒÓỌỎÕÔỒỐỘỔỖƠỜỚỢỞỠÙÚỤỦŨƯỪỨỰỬỮỲÝỴỶỸĐ]+)*){4,40}$";
    private Long id;
    @NotBlank(message = "Vui lòng nhập trường này!")
    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$",
            message = "Vui lòng nhập đúng email!")
    private String email;
    @NotBlank(message = "Vui lòng nhập trường này!")
    @Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9]).{8,30}$",
            message = "Vui lòng nhập mật khẩu tối thiểu 8 ký tự bao gồm chữ in hoa, chữ thường, số!")
    private String password;
    @NotBlank(message = "Vui lòng nhập trường này!")
    @Pattern(regexp = "((NV-|nv-)\\d{4})",
            message = "Vui lòng nhập theo định dạng NV-XXXX !")
    private String code;
    @NotBlank(message = "Vui lòng nhập trường này!")
    @Pattern(regexp = REGEX_NAME,
            message = "Vui lòng nhập 6-40 ký tự không bao gồm số và ký tự đặc biệt!")
    private String name;
    @NotBlank(message = "Vui lòng nhập trường này!")
    private String birthday;
    private Boolean gender;
    @NotBlank(message = "Vui lòng nhập trường này!")
    @Pattern(regexp = "^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$",
            message = "Vui lòng nhập đúng định dạng 09xxxxxxxx hoặc +849xxxxxxxx!")
    private String phone;
    @NotBlank(message = "Vui lòng nhập trường này!")
    @Pattern(regexp = REGEX_ADDRESS,
            message = "Vui lòng nhập 6-40 ký tự không bao gồm ký tự đặc biệt!")
    private String address;
    @NotNull
    private Long id_ward;
    @NotNull
    private Long id_position;
    private Long account_id;
    private Boolean delFlag;

    public EmployeeDto() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
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

    public Long getId_ward() {
        return id_ward;
    }

    public void setId_ward(Long id_ward) {
        this.id_ward = id_ward;
    }

    public Long getId_position() {
        return id_position;
    }

    public void setId_position(Long id_position) {
        this.id_position = id_position;
    }

    public Long getAccount_id() {
        return account_id;
    }

    public void setAccount_id(Long account_id) {
        this.account_id = account_id;
    }

    public Boolean getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Boolean delFlag) {
        this.delFlag = delFlag;
    }
}
