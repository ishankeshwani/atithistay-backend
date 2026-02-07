package com.ishan.AtithiStay.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateRoomRequest {
    private String roomNumber;
    private Double price;
    private Integer capacity;

}
