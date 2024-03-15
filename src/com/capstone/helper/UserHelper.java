package com.capstone.helper;

import java.util.UUID;

public class UserHelper {
    public static UUID extractUserID(String uuid) {
        UUID result;
        try {
            result = UUID.fromString(uuid);
        } catch (IllegalArgumentException e) {
            return null;
        }
        return result;
    }
}
