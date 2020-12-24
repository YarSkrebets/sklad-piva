package ru.sonicxd2.sklad.product;

public enum ProductStatus {
    UNVERIFIED, // Только пришел, не проверенный
    VERIFIED, // Проверенный со сроками годности и.т.д
    SPOILED, // Испортился
    SELLED, // Продан
    DESTRUCTED_BY_KAMAZ; // Испортился из-за того что испортился или контрофактная продукция
}
