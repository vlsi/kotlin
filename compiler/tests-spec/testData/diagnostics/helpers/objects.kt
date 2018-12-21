object _EmptyObject {}

object _Object {
    val prop_1: Number? = 1
    val prop_2: Number = 1
}

object _DeepObject {
    val prop_1 = null
    var prop_2 = null
    object A {
        object B {
            object C {
                object D {
                    object E {
                        object F {
                            object G {
                                object J {
                                    val x: Int? = 10
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}