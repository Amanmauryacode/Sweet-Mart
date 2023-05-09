let logo = document.getElementById("logo");

logo.addEventListener("click", () => {
    window.location.href = "./index.html"
})

let form = document.querySelector("form");
let email = document.getElementById("email")
let password = document.getElementById("password");
let password_2 = document.getElementById("password-2");
let code = document.getElementById("code");
let error = document.getElementById("error");
let pin = document.getElementById("pin");


var val = Math.floor(1000 + Math.random() * 9000);
pin.innerText = val;
// pin.innerText = val;


form.addEventListener("submit", (e) => {
    e.preventDefault();
    error.innerText = "";
    if (password.value.length >= 8 && password_2.value != "") {
        if (password.value == password_2.value && code.value == val) {

            let data = {
                userName: email.value,
                password: password.value,
                confirmedPassword: password_2.value
            }
            registerUser(data);
        } else {
            if (code.value != val) {
                error.innerText = "Incorrect code"
                error.style.color = "red"
            } else {
                error.innerText = "Password not match"
                error.style.color = "red"
            }

        }
    } else {
        error.innerText = "Password Must greater than 8 digit"
        error.style.color = "red"
    }


})

function registerUser(userObject) {
    let res;
    var myHeaders = new Headers();
    myHeaders.append("Content-Type", "application/json");

    var requestOptions = {
        method: 'POST',
        headers: myHeaders,
        body: JSON.stringify(userObject)
    };

    fetch("http://localhost:8088/customers", requestOptions)
        .then(response => response.json())
        .then(result => {
            if(result.messags == undefined){
                alert("Register");
                window.location.href = "../HTML/index.html"
            }else{
                alert(result.messags);
            }
        })
        .catch(error => console.log('error', error));

    return res;
}