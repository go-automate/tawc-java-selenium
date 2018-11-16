function validate() {
    var name = document.getElementsByName("uname")[0].value;
    var pwd = document.getElementsByName("psw")[0].value;
    if (name == "tester" && pwd == "letmein" || name == "tester1" && pwd == "letmein" || name == "tester2" && pwd == "letmein"  ) {
        window.location = "/tools";
    } else {
    incorrectPassword();
    }
}
function incorrectPassword() {
    document.getElementById('rejectLogin').innerHTML = '<b>WARNING: Username or Password is incorrect</b>';
}