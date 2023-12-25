function populateTasks(tasks) {
    const tasksWrapper = document.querySelector('.tasks-wrapper');
    const tasksWrapper_upcomingHeader = document.querySelector('.tasks-wrapper .upcoming.header');
    tasks.forEach((task, index) => {
        const taskDiv = document.createElement('div');
        taskDiv.classList.add('task');

        const inputCheckbox = document.createElement('input');
        inputCheckbox.classList.add('task-item');
        inputCheckbox.name = 'task';
        inputCheckbox.type = 'checkbox';
        inputCheckbox.id = index + 1; // sau folosește altceva în loc de index

        if (task.status === 'Done') {
            inputCheckbox.checked = true;
        }

        const label = document.createElement('label');
        label.htmlFor = index + 1;
        const labelText = document.createElement('span');
        labelText.classList.add('label-text');
        labelText.textContent = task.name;

        label.appendChild(labelText);

        const tagSpan = document.createElement('span');
        tagSpan.classList.add('tag');
        if (task.status === 'Approved') {
            tagSpan.classList.add('approved');
        } else if (task.status === 'In Progress') {
            tagSpan.classList.add('progress');
        } else if (task.status === 'In Review') {
            tagSpan.classList.add('review');

        }
        if (task.status === 'Waiting') {
            tagSpan.classList.add('waiting');
            tagSpan.textContent = task.status;

            taskDiv.appendChild(inputCheckbox);
            taskDiv.appendChild(label);
            taskDiv.appendChild(tagSpan);
            tasksWrapper_upcomingHeader.appendChild(taskDiv);
        } else {
            tagSpan.textContent = task.status;
            taskDiv.appendChild(inputCheckbox);
            taskDiv.appendChild(label);
            taskDiv.appendChild(tagSpan);
            tasksWrapper.appendChild(taskDiv);
        }


    });
}


document.addEventListener("DOMContentLoaded", function () {
    // Face o cerere către server pentru a obține datele
    fetch('/get_tasks_data')
        .then(response => response.json())
        .then(data => {
            // Apelul funcției populateTasks din populateTasks.js cu datele obținute
            populateTasks(data);
        });
});

// // Găsește butonul după id
// const saveButton = document.getElementById('saveButton');
//
// // Adaugă un eveniment de click la buton
// saveButton.addEventListener('click', function () {
//     // Aici poți prelua datele task-ului (nume și stare) din interfața web
//     const taskName = document.getElementById("fname").value /* preiați numele task-ului din interfața web */;
//     const taskStatus = document.getElementById("status1").value /* preiați starea task-ului din interfața web */;
//     if (taskName && taskStatus) {
//         saveTask(taskName, taskStatus);
//     } else {
//         console.error('Invalid task data');
//     }
//
// });
//
//
// function saveTask(name, status) {
//     fetch('/save_task', {
//         method: 'POST',
//         headers: {
//             'Content-Type': 'application/json',
//         },
//         body: JSON.stringify({
//             name: name,
//             status: status,
//         }),
//     })
//         .then(response => response.json())
//         .then(data => {
//             console.log('Task saved:', data);
//             console.log(data);
//         })
//         .catch(error => {
//             console.error('Error saving task:', error);
//         });
// }

import { globalVar1, globalVar2 } from '/static/js/global.js';

console.log(globalVar1); // Va afișa 'Valoare 1'
console.log(globalVar2); // Va afișa 'Valoare 2'
