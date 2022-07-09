package org.example;


import net.datafaker.Address;

public record Publisher(String country, String city, String zipcode, String streetAddress) {
    public static Publisher of( Address address) {
        return new Publisher(address.country(), address.city(), address.zipCode(), address.streetAddress());
    }
}
