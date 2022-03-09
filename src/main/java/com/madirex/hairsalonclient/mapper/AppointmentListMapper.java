package com.madirex.hairsalonclient.mapper;

import com.madirex.hairsalonclient.model.Appointment;
import com.madirex.hairsalonclient.model.AppointmentList;

import java.util.List;
import java.util.stream.Collectors;

public class AppointmentListMapper {
    public AppointmentList toListItem(Appointment appointment) {
        return new AppointmentList(
                appointment.getId()
                , appointment.getUser().getUsername()
                , appointment.getService().getName()
                , appointment.getTime().toString()
                , appointment.getDate().toString()
        );
    }

    public List<AppointmentList> toList(List<Appointment> list) {
        return list.stream().map(this::toListItem).collect(Collectors.toList());
    }
}
