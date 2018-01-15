    $(document).ready(function () {
        $('#signup').on('click', function () {
            $("#signup-modal").modal();
            $("#signup-modal-body").text("");
            $.ajax({
                url: "signup",
                cache: false
            }).done(function (html) {
                $("#signup-modal-body").append(html);
            });
        });
    });

          function displayNextImage() {
              x = (x === images.length - 1) ? 0 : x + 1;
             document.getElementById("soldPropertiesImage").src = images[x];
          }

          function displayPreviousImage() {
              x = (x <= 0) ? images.length - 1 : x - 1;
              document.getElementById("soldPropertiesImage").src = images[x];
          }

          function startTimer() {
              setInterval(displayNextImage, 4000);
          }

          var images = [], x = -1;
          images[0] = "resources/images/propertiesSold/sold2.jpg";
          images[1] = "resources/images/propertiesSold/sold3.jpg";
          images[2] = "resources/images/propertiesSold/sold4.jpg";
     