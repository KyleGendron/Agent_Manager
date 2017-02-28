package com.voice.app.Agent_Manager.utils;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * Simple LocalDate Attribute converter for use with Hibernate's JPA Annotations.
 * Found originally at: http://www.thoughts-on-java.org/persist-localdate-localdatetime-jpa/
 * 
 * Author Name included in the case of that reference failing.
 * 
 * @author Thorben Janssen
 *
 */

@Converter(autoApply = true)
public class LocalDateAttributeConverter implements AttributeConverter<LocalDate, Date> {
	
    @Override
    public Date convertToDatabaseColumn(LocalDate locDate) {
    	return (locDate == null ? null : Date.valueOf(locDate));
    }

    @Override
    public LocalDate convertToEntityAttribute(Date sqlDate) {
    	return (sqlDate == null ? null : sqlDate.toLocalDate());
    }
}