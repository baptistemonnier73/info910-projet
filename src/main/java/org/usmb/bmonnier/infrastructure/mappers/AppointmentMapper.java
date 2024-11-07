package org.usmb.bmonnier.infrastructure.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.core.convert.converter.Converter;
import org.usmb.bmonnier.domain.models.Appointment;
import org.usmb.bmonnier.infrastructure.entities.AppointmentEntity;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

public interface AppointmentMapper {
    @Mapper(componentModel = SPRING)
    interface ToDatabase extends Converter<Appointment, AppointmentEntity> {
        @Override
        @Mapping(target = "id", ignore = true)
        @Mapping(target = "user", ignore = true)
        AppointmentEntity convert(Appointment source);
    }

    @Mapper(componentModel = SPRING)
    interface FromDatabase extends Converter<AppointmentEntity, Appointment> {
        @Override
        Appointment convert(AppointmentEntity source);
    }
}
