// "Remove explicitly specified return type of current function" "true"
// ERROR: Function declaration must have a name
fun (): Int {
    return<caret>
}