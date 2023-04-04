package com.acme.sprocket.service;

import ch.qos.logback.core.sift.SiftProcessor;

import java.util.UUID;

public interface SprocketService {
    SprocketResponse insert(final SprocketInsertRequest sprocketInsertRequest);
    SprocketResponse findOne(final UUID id);
}
