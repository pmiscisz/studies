package org.example;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import jakarta.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.RPC)
public interface MyFirstSOAPInterface {
    @WebMethod String getHelloWorldAsString(String name);
    @WebMethod long getDaysBetweenDates(String date1, String date2);
}