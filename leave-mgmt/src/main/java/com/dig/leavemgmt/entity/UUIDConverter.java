package com.dig.leavemgmt.entity;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.nio.ByteBuffer;
import java.util.UUID;

//@Converter(autoApply = true)
public class UUIDConverter implements AttributeConverter<UUID,byte[]> {

    @Override
    public byte[] convertToDatabaseColumn(UUID uuid) {
        ByteBuffer byteBuffer=ByteBuffer.wrap(new byte[16]);
        byteBuffer.putLong(uuid.getMostSignificantBits());
        byteBuffer.putLong(uuid.getLeastSignificantBits());
        return byteBuffer.array();
    }

    @Override
    public UUID convertToEntityAttribute(byte[] bytes) {
        ByteBuffer byteBuffer=ByteBuffer.wrap(bytes);
        return new UUID(byteBuffer.getLong(),byteBuffer.getLong());
    }
}
