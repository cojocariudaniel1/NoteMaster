

document.querySelector(".form-submit").addEventListener("click", function () {
        
        const username = document.getElementById("username_id").value;
        const password = document.getElementById("password_id").value;

        const dataToSend = { username: username, password: password};
        console.log(dataToSend);
        checkAccount(dataToSend);



    }
);


async function checkAccount(dataToSend) {
     fetch("http://localhost:8080/utilizator/login", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(dataToSend),
      })
        .then(response => response.json())
        .then(data => {
          console.log("Răspuns de la server:", data);
          window.location.href = "notes.html";
          // Aici poți face ceva cu rezultatul primit de la server
        })
        .catch(error => {
          displayErrorMessage("Username or password incorrect!");
          console.error("Probleme cu API verify account", error);
        });
};

function getAllUsers() {
  fetch("http://localhost:8080/utilizator")
      .then(response => {
          if (!response.ok) {
              throw new Error(`HTTP error! Status: ${response.status}`);
          }
          return response.json();
      })
      .then(data => {
          console.log("Lista utilizatorilor:", data);
          // Aici poți face ceva cu rezultatul primit de la server
      })
      .catch(error => {
          console.error("Eroare la preluarea listei utilizatorilor", error);

          console.error("Eroare la procesarea listei utilizatorilor");
      });
};

function displayErrorMessage(message) {
  const errorMessage = document.getElementById("error-message");
  errorMessage.textContent = message;
  errorMessage.style.display = "block";
}