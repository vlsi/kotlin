enum class _EnumClass {
    NORTH, SOUTH, WEST, EAST
}

enum class _EnumClassSingle {
    EVERYTHING
}

enum class _EnumClassEmpty

enum class _EnumClassWithNullableProperty(val prop_1: Int?) {
    A(1),
    B(5),
    D(null)
}

enum class _EnumClassWithProperty(val prop_1: Int) {
    A(1),
    B(5),
    D(6)
}