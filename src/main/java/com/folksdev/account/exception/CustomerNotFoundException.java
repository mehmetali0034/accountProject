package com.folksdev.account.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/*
Bu Java kodu, bir istisna (exception) sınıfı olan CustomerNotFoundException'ı tanımlar. Bu sınıf, RuntimeException
sınıfından türetilmiştir, bu da bu istisna sınıfının çalışma zamanı hatası olduğunu ve kodun normal akışının dışında bir
durumun meydana geldiğini belirtir.
Bu metod, bir mesaj dizisi (String message) alır ve bu mesajı super(message) ifadesiyle üst sınıfa (yani RuntimeException
sınıfına) iletir. Böylece, bu sınıfın bir örneği oluşturulduğunda, bu mesajın içeren bir istisna fırlatılabilir. Mesaj,
istisnanın nedenini veya bağlamını açıklamak için kullanılır.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
//Biz burada girdiği id değernin yanlış olması durumuna baktık. Eğer girdiği request'in işsel olarak kurallarına ayrkırı bir
//durum için baksaydık Bad Reuest kulanırdık.
public class CustomerNotFoundException extends RuntimeException{
    public CustomerNotFoundException(String message) {
        super(message);
    }
}
