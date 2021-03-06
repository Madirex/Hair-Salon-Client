package com.madirex.hairsalonclient.restcontroller;


import com.madirex.hairsalonclient.model.Appointment;
import com.madirex.hairsalonclient.model.createDTOs.CreateAppointmentDTO;
import retrofit2.Call;
import retrofit2.http.*;

import java.time.LocalDate;
import java.util.List;

public interface RestAPIAppointments {

    @GET(APIRestConfig.API_PATH + "/appointments/")
    Call<List<Appointment>> appointmentsGetAll(@Header("Authorization") String token);

    @GET(APIRestConfig.API_PATH + "/appointments/")
    Call<Appointment> appointmentGetAllWithDate(@Header("Authorization") String token, @Query("date") LocalDate date);

    @GET(APIRestConfig.API_PATH + "/appointments/")
    Call<List<Appointment>> appointmentGetAllWithUser_Username(@Header("Authorization") String token, @Query("searchQuery") String searchQuery);

    @GET(APIRestConfig.API_PATH + "/appointments/")
    Call<List<Appointment>> appointmentFindByDateAndUser_UsernameContainsIgnoreCaseAndService_Id(
            @Header("Authorization") String token,
            @Query("searchQuery") String searchQuery
            , @Query("date") LocalDate date
            , @Query("service_id") String serviceId);

    @GET(APIRestConfig.API_PATH + "/appointments/{id}")
    Call<Appointment> appointmentGetById(@Header("Authorization") String token, @Path("id") String id);

    @POST(APIRestConfig.API_PATH + "/appointments/")
    Call<Appointment> insertAppointments(@Header("Authorization") String token, @Body CreateAppointmentDTO appointment);

    @PUT(APIRestConfig.API_PATH + "/appointments/{id}")
    Call<Appointment> updateAppointments(@Header("Authorization") String token);

    @DELETE(APIRestConfig.API_PATH + "/appointments/{id}")
    Call<Appointment> deleteAppointmentById(@Header("Authorization") String token, @Path("id") String id);
}
