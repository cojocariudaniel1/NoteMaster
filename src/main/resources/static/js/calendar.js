var app = {
    settings: {
      container: document.querySelector(".calendar"),
      calendar: document.querySelector(".front"),
      days: document.querySelectorAll(".weeks span"),
      form: document.querySelector(".back"),
      input: document.querySelector(".back input"),
      buttons: document.querySelectorAll(".back button"),
      activeDate: null
    },
  
    init: function () {
      var settings = this.settings;
  
      // Load saved events from local storage
      var savedEvents = JSON.parse(localStorage.getItem("events")) || {};
      this.loadSavedEvents(savedEvents);
  
      settings.days.forEach(function (day) {
        day.addEventListener("click", function () {
          settings.activeDate = day.textContent;
          app.swap(settings.calendar, settings.form);
          settings.input.focus();
        });
      });
  
      settings.buttons.forEach(function (button) {
        button.addEventListener("click", function () {
          if (button.classList.contains("save")) {
            // Save logic
            var eventText = settings.input.value.trim();
  
            if (eventText) {
              var savedEvents = JSON.parse(localStorage.getItem("events")) || {};
  
              // Check if events already exist for the active date
              if (!savedEvents[settings.activeDate]) {
                savedEvents[settings.activeDate] = [];
              }
  
              // Save the event for the active date
              savedEvents[settings.activeDate].push({
                text: eventText,
                time: new Date().toLocaleTimeString(),
                address: "Your address", // You can modify this as needed
                observations: "Your observations" // You can modify this as needed
              });
  
              // Update localStorage
              localStorage.setItem("events", JSON.stringify(savedEvents));
  
              // Reset input value
              settings.input.value = "";
  
              // Mark the day with the "event" class
              var activeDay = app.findActiveDay(settings.activeDate);
              if (activeDay) {
                activeDay.classList.add("event");
              }
            }
          }
  
          app.swap(settings.form, settings.calendar);
        });
      });
    },
  
    swap: function (currentSide, desiredSide) {
      app.settings.container.classList.toggle("flip");
      currentSide.style.display = "none";
      desiredSide.style.display = "block";
    },
  
    findActiveDay: function (activeDate) {
      var days = document.querySelectorAll(".weeks span");
      for (var i = 0; i < days.length; i++) {
        if (days[i].textContent === activeDate) {
          return days[i];
        }
      }
      return null;
    },
  
    loadSavedEvents: function (savedEvents) {
      for (var date in savedEvents) {
        var day = this.findActiveDay(date);
        if (day) {
          day.classList.add("event");
        }
      }
    }
  };
  
  app.init();
  