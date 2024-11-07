package org.usmb.bmonnier.infrastructure.mappers;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.core.convert.converter.Converter;
import org.usmb.bmonnier.domain.models.User;
import org.usmb.bmonnier.infrastructure.entities.UserEntity;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface UserMapper {

    @Mapper(componentModel = SPRING)
    interface ToDatabase extends Converter<User, UserEntity> {
        @Override
        UserEntity convert(User source);

        @AfterMapping
        default void mapUsersInAppointment(User source, @MappingTarget UserEntity destination) {
            destination.getAppointments().forEach(appointment ->
                    appointment.setUser(destination));
        }
    }

    @Mapper(componentModel = SPRING)
    interface FromDatabase extends Converter<UserEntity, User> {
        @Override
        User convert(UserEntity source);
    }
}
