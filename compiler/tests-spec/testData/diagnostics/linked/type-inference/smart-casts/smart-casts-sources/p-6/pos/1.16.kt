// !LANGUAGE: +NewInference
// !DIAGNOSTICS: -UNUSED_EXPRESSION
// SKIP_TXT

/*
 * KOTLIN DIAGNOSTICS SPEC TEST (POSITIVE)
 *
 * SPEC VERSION: 0.1-draft
 * PLACE: type-inference, smart-casts, smart-casts-sources -> paragraph 6 -> sentence 1
 * NUMBER: 15
 * DESCRIPTION: Nullability condition, if, constrol flow, return, if
 * HELPERS: objects, properties, classes
 */

// TESTCASE NUMBER: 1
fun case_1(x: Int?) {
    if (x == null) return
    <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Int & kotlin.Int?")!>x<!>
    <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Int? & kotlin.Int"), DEBUG_INFO_SMARTCAST!>x<!>.inv()
}

// TESTCASE NUMBER: 2
fun case_2(x: Unit?) {
    if (x === null) return
    <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Unit & kotlin.Unit?")!>x<!>
    <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Unit & kotlin.Unit?")!>x<!>.<!DEBUG_INFO_UNRESOLVED_WITH_TARGET, UNRESOLVED_REFERENCE_WRONG_RECEIVER!>inv<!>()
}

// TESTCASE NUMBER: 3
fun case_3(x: Nothing?) {
    if (<!SENSELESS_COMPARISON!><!DEBUG_INFO_CONSTANT!>x<!> != null<!>) else return
    <!DEBUG_INFO_CONSTANT, DEBUG_INFO_EXPRESSION_TYPE("kotlin.Nothing?")!>x<!>
    <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Nothing?"), SMARTCAST_IMPOSSIBLE!>x<!>.<!MISSING_DEPENDENCY_CLASS, MISSING_DEPENDENCY_CLASS!>inv<!>()
}

// TESTCASE NUMBER: 4
fun case_4(x: Number?) {
    if (x !== null) else { return }
    <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Number & kotlin.Number?")!>x<!>
    <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Number & kotlin.Number?")!>x<!>.<!DEBUG_INFO_UNRESOLVED_WITH_TARGET, UNRESOLVED_REFERENCE_WRONG_RECEIVER!>inv<!>()
}

// TESTCASE NUMBER: 5
fun case_5(x: Char?, y: Nothing?) {
    if (x != <!DEBUG_INFO_CONSTANT!>y<!>) else return
    <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Char & kotlin.Char?")!>x<!>
    <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Char & kotlin.Char?")!>x<!>.<!DEBUG_INFO_UNRESOLVED_WITH_TARGET, UNRESOLVED_REFERENCE_WRONG_RECEIVER!>inv<!>()
}

// TESTCASE NUMBER: 6
fun case_6(x: _Object?) {
    if (x !== <!DEBUG_INFO_CONSTANT!>implicitNullableNothingProperty<!>) else { return }
    <!DEBUG_INFO_EXPRESSION_TYPE("_Object & _Object?")!>x<!>
    <!DEBUG_INFO_EXPRESSION_TYPE("_Object? & _Object"), DEBUG_INFO_SMARTCAST!>x<!>.equals(x)
}

// TESTCASE NUMBER: 7
fun case_7(x: _Class?) {
    if (x === <!DEBUG_INFO_CONSTANT!>implicitNullableNothingProperty<!> || false || false || false) { return }
    <!DEBUG_INFO_EXPRESSION_TYPE("_Class & _Class?")!>x<!>
    <!DEBUG_INFO_EXPRESSION_TYPE("_Class? & _Class"), DEBUG_INFO_SMARTCAST!>x<!>.equals(x)
}

// TESTCASE NUMBER: 8
fun case_8(x: Int?) {
    if (false || false || false || x == <!DEBUG_INFO_CONSTANT!>nullableNothingProperty<!>) return
    <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Int & kotlin.Int?")!>x<!>
    <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Int? & kotlin.Int"), DEBUG_INFO_SMARTCAST!>x<!>.inv()
}

// TESTCASE NUMBER: 9
fun case_9(x: String?) {
    if (x != <!DEBUG_INFO_CONSTANT!>implicitNullableNothingProperty<!> && true && true && true) else { return }
    <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.String & kotlin.String?")!>x<!>
    <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.String & kotlin.String?")!>x<!>.<!DEBUG_INFO_UNRESOLVED_WITH_TARGET, UNRESOLVED_REFERENCE_WRONG_RECEIVER!>inv<!>()
}

// TESTCASE NUMBER: 10
fun case_10(x: Float?) {
    if (true && true && true && x !== null) else return
    <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Float & kotlin.Float?")!>x<!>
    <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Float & kotlin.Float?")!>x<!>.<!DEBUG_INFO_UNRESOLVED_WITH_TARGET, UNRESOLVED_REFERENCE_WRONG_RECEIVER!>inv<!>()
}

// TESTCASE NUMBER: 11
fun case_11(x: List<*>?) {
    if (x == null) return
    <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.collections.List<*> & kotlin.collections.List<*>?")!>x<!>
    <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.collections.List<*> & kotlin.collections.List<*>?")!>x<!>.equals(x)
}

// TESTCASE NUMBER: 12
fun case_12(x: Map<Unit, Nothing?>?) {
    if (x === null) return
    <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.collections.Map<kotlin.Unit, kotlin.Nothing?> & kotlin.collections.Map<kotlin.Unit, kotlin.Nothing?>?")!>x<!>
    <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.collections.Map<kotlin.Unit, kotlin.Nothing?>? & kotlin.collections.Map<kotlin.Unit, kotlin.Nothing?>"), DEBUG_INFO_SMARTCAST!>x<!>.equals(x)
}

// TESTCASE NUMBER: 13
fun case_13(x: Map<out Number, *>?) {
    if (x != null) else return
    <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.collections.Map<out kotlin.Number, *> & kotlin.collections.Map<out kotlin.Number, *>?")!>x<!>
    <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.collections.Map<out kotlin.Number, *> & kotlin.collections.Map<out kotlin.Number, *>?")!>x<!>.equals(x)
}

// TESTCASE NUMBER: 14
fun case_14(x: MutableCollection<in Number>?) {
    if (x !== null) else { return }
    <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.collections.MutableCollection<in kotlin.Number> & kotlin.collections.MutableCollection<in kotlin.Number>?")!>x<!>
    <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.collections.MutableCollection<in kotlin.Number> & kotlin.collections.MutableCollection<in kotlin.Number>?")!>x<!>.equals(x)
}

// TESTCASE NUMBER: 15
fun case_15(x: MutableCollection<out Nothing?>?, y: Nothing?) {
    if (x != <!DEBUG_INFO_CONSTANT!>y<!>) else return
    <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.collections.MutableCollection<out kotlin.Nothing?> & kotlin.collections.MutableCollection<out kotlin.Nothing?>?")!>x<!>
    <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.collections.MutableCollection<out kotlin.Nothing?> & kotlin.collections.MutableCollection<out kotlin.Nothing?>?")!>x<!>.equals(x)
}

// TESTCASE NUMBER: 16
fun case_16(x: Collection<Collection<Collection<Collection<Collection<Collection<Collection<*>>>>>>>?) {
    if (x !== <!DEBUG_INFO_CONSTANT!>implicitNullableNothingProperty<!>) else { return }
    <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.collections.Collection<kotlin.collections.Collection<kotlin.collections.Collection<kotlin.collections.Collection<kotlin.collections.Collection<kotlin.collections.Collection<kotlin.collections.Collection<*>>>>>>> & kotlin.collections.Collection<kotlin.collections.Collection<kotlin.collections.Collection<kotlin.collections.Collection<kotlin.collections.Collection<kotlin.collections.Collection<kotlin.collections.Collection<*>>>>>>>?")!>x<!>
    <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.collections.Collection<kotlin.collections.Collection<kotlin.collections.Collection<kotlin.collections.Collection<kotlin.collections.Collection<kotlin.collections.Collection<kotlin.collections.Collection<*>>>>>>>? & kotlin.collections.Collection<kotlin.collections.Collection<kotlin.collections.Collection<kotlin.collections.Collection<kotlin.collections.Collection<kotlin.collections.Collection<kotlin.collections.Collection<*>>>>>>>"), DEBUG_INFO_SMARTCAST!>x<!>.equals(x)
}

// TESTCASE NUMBER: 17
fun case_17(x: MutableMap<*, *>?) {
    if (x === <!DEBUG_INFO_CONSTANT!>implicitNullableNothingProperty<!> || false) { return }
    <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.collections.MutableMap<*, *> & kotlin.collections.MutableMap<*, *>?")!>x<!>
    <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.collections.MutableMap<*, *> & kotlin.collections.MutableMap<*, *>?")!>x<!>.equals(x)
}

// TESTCASE NUMBER: 18
fun case_18(x: MutableMap<out Number, in Number>?) {
    if (false || false || false || x == <!DEBUG_INFO_CONSTANT!>nullableNothingProperty<!>) return
    <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.collections.MutableMap<out kotlin.Number, in kotlin.Number> & kotlin.collections.MutableMap<out kotlin.Number, in kotlin.Number>?")!>x<!>
    <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.collections.MutableMap<out kotlin.Number, in kotlin.Number> & kotlin.collections.MutableMap<out kotlin.Number, in kotlin.Number>?")!>x<!>.equals(x)
}

// TESTCASE NUMBER: 19
fun case_19(x: MutableList<in MutableList<in MutableList<in MutableList<in MutableList<in MutableList<in MutableList<in Int>>>>>>>?) {
    if (x === <!DEBUG_INFO_CONSTANT!>implicitNullableNothingProperty<!> && true) else { return }
    <!DEBUG_INFO_CONSTANT, DEBUG_INFO_EXPRESSION_TYPE("kotlin.Nothing? & kotlin.collections.MutableList<in kotlin.collections.MutableList<in kotlin.collections.MutableList<in kotlin.collections.MutableList<in kotlin.collections.MutableList<in kotlin.collections.MutableList<in kotlin.collections.MutableList<in kotlin.Int>>>>>>>?")!>x<!>
    <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Nothing? & kotlin.collections.MutableList<in kotlin.collections.MutableList<in kotlin.collections.MutableList<in kotlin.collections.MutableList<in kotlin.collections.MutableList<in kotlin.collections.MutableList<in kotlin.collections.MutableList<in kotlin.Int>>>>>>>?")!>x<!>.equals(<!DEBUG_INFO_CONSTANT!>x<!>)
}

// TESTCASE NUMBER: 20
fun case_20(x: MutableList<out MutableList<out MutableList<out MutableList<out MutableList<out MutableList<out MutableList<out Number>>>>>>>?) {
    if (true && true && true && x !== null) else return
    <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.Number>>>>>>> & kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.Number>>>>>>>?")!>x<!>
    <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.Number>>>>>>> & kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.Number>>>>>>>?")!>x<!>.equals(x)
}

// TESTCASE NUMBER: 21
fun <T> case_21(x: T) {
    if (x == null) return
    <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.Number>>>>>>> & kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.Number>>>>>>>?")!>x<!>
    <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.Number>>>>>>> & kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.Number>>>>>>>?")!>x<!>.equals(x)
}

// TESTCASE NUMBER: 22
fun <T> case_22(x: T?) {
    if (x === null) return
    <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.Number>>>>>>> & kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.Number>>>>>>>?")!>x<!>
    <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.Number>>>>>>> & kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.Number>>>>>>>?")!>x<!>.equals(x)
}

// TESTCASE NUMBER: 23
fun <T> case_23(x: MutableList<in T>?) {
    if (x !== null) else return
    <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.Number>>>>>>> & kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.Number>>>>>>>?")!>x<!>
    <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.Number>>>>>>> & kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.Number>>>>>>>?")!>x<!>.equals(x)
}

// TESTCASE NUMBER: 24
fun <T> case_24(x: MutableList<out T?>?, y: Nothing?) {
    if (x !== y && true) else return
    <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.Number>>>>>>> & kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.Number>>>>>>>?")!>x<!>
    <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.Number>>>>>>> & kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.collections.MutableList<out kotlin.Number>>>>>>>?")!>x<!>.equals(x)
}

class A<T>(val x: T) {
    fun f() = x
}

class B<T1>(val x: T1) {
    fun f(): T1 = x
}

inline fun <reified T, reified K, M> case_25(x: T, y: K) {
    x as Map<K, M?>
    if (x is K?) {
        val y = B(x)
        val t = y.f()
        if (t != null) {
            <!DEBUG_INFO_EXPRESSION_TYPE("t")!>t<!>
        }
    }
}