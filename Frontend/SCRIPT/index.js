
let logo = document.getElementById("logo");

logo.addEventListener("click", () => {
    window.location.href = "./index.html"
})
let RegisterData = JSON.parse(localStorage.getItem("loginData")) || [];
let form = document.querySelector("form");
let email = document.getElementById("email");
let password = document.getElementById("password");
let error = document.getElementById("error");
let loginstatus = document.getElementById("login");
let adminStatus = document.getElementById("Admin");


form.addEventListener("submit", (e) => {
    e.preventDefault();
    error.innerText = "";
    let em = email.value;
    let p = password.value;

    if (em == "admin@sweetmart.com" && p == "Admin@1212") {
        let data = {
            userName:em,
	        password:p,
	        role: "Admin"
        }
        login(data)

    } else {

        let data = {
            userName:em,
	        password:p,
	        role: "Customer"
        }
        login(data);
        
    }

    function login(data) {
        var ld={} ;
        var myHeaders = new Headers();
        myHeaders.append("Content-Type", "application/json");

        var raw = JSON.stringify(data);

        var requestOptions = {
            method: 'POST',
            headers: myHeaders,
            body: raw,
            redirect: 'follow'
        };

        fetch("http://localhost:8088/login", requestOptions)
            .then(response => response.json())
            .then(result =>{

                if(result.messags == undefined){
                    alert("Logged In");
                    localStorage.setItem("user",JSON.stringify(result));
                    if(result.role === "Admin"){
                        window.location.href = "../HTML/Admin.html"
                    }else{
                        window.location.href = "../HTML/customer.html"
                    }
                    
                }else{
                    if(result.messags === "User already Logged In with this name"){
                        alert(result.messags);
                        if(result.role === "Admin"){
                            window.location.href = "../HTML/Admin.html"
                        }else{
                            window.location.href = "../HTML/customer.html"
                        }
                    }
                    alert(result.messags);
                }


            })
            .catch(error => console.log('error', error));
    }



})

