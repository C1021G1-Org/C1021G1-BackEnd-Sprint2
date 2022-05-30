package com.example.carparkingmanagementbe.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SignForm {

    private static final String REGEX_NAME = "^[a-zA-ZàáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợởỡùúụủũưừứựửữỳýỵỷỹđÀÁẠẢÃÂẦẤẬẨẪĂẰẮẶẲẴÈÉẸẺẼÊỀẾỆỂỄÌÍỊỈĨÒÓỌỎÕÔỒỐỘỔỖƠỜỚỢỞỠÙÚỤỦŨƯỪỨỰỬỮỲÝỴỶỸĐ]+(\\s[a-zA-ZàáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợởỡùúụủũưừứựửữỳýỵỷỹđÀÁẠẢÃÂẦẤẬẨẪĂẰẮẶẲẴÈÉẸẺẼÊỀẾỆỂỄÌÍỊỈĨÒÓỌỎÕÔỒỐỘỔỖƠỜỚỢỞỠÙÚỤỦŨƯỪỨỰỬỮỲÝỴỶỸĐ]+)*$";
    private static final String REGEX_PHONE = "^([0-9])*$";

    @Size(max = 40, message = "Tối đa 40 kí tự!")
    @Pattern(regexp = REGEX_NAME, message = "Vui lòng nhập đúng tên của bạn!")
    @NotEmpty(message = "Trường này không thể để trống.")
    private String name;

    @Size(max = 40, message = "Tối đa 40 kí tự!")
    @NotEmpty(message = "Trường này không thể để trống.")
    private String address;

    @NotNull(message = "Trường này không thể để trống.")
    private Boolean gender;

    @NotBlank(message = "Trường này không thể để trống.")
    private String dateOfBirth;

    @Size(min = 10,max = 12, message = "Tối đa 12 số!")
    @Pattern(regexp = REGEX_PHONE, message = "Vui lòng nhập đúng số điện thoại!")
    @NotBlank(message = "Trường này không thể để trống.")
    private String phone;

    @Size(max = 40, message = "Tối đa 40 kí tự!")
    @NotBlank(message = "Trường này không thể để trống.")
    @Email(message = "Phải đúng định dạng email ví dụ: abc@gmail.com")
    private String email;

    @NotBlank(message = "Vui lòng không được để trống")
    @Size(min = 8, max = 20, message = "Mật khẩu phải có từ 8-20 ký tự")
    private String password;

    @Size(min = 9,max = 12, message = "Nhập tối đa 9 đến 12 số.")
    @NotBlank(message = "Vui lòng nhập CMND/CCCD")
    private String idCard;
    private Long idWard;
}
