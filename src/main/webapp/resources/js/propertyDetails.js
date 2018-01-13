
 window.onload = function() {
       var propertyId = document.getElementById('propertyId').innerText;
       if(localStorage.getItem(propertyId) == "sent" ){
           document.getElementById('detailsBtn').innerText = "Details Sent!";
           document.getElementById('detailsBtn').disabled = true; 
           
        }
    }
    
    
        function sendDetails(){
        
        var r = confirm("Your details will be sent to the landlord of the property.\n\nAre you sure you want to proceed?");
            if (r == true) {
                document.getElementById('detailsBtn').innerText = "Details Sent!";
                document.getElementById('detailsBtn').disabled = true;   
                var propertyId = document.getElementById('propertyId').innerText;
                localStorage.setItem(propertyId, 'sent');
                window.alert("Your details were sent successfully! \n\nThe landlord will contact you soon",5);
            } 
       }
    
    var image_path = document.getElementById('image_path').innerText;
         var images = [], x = 0;
          images[0] = image_path + '/1.jpg';
          images[1] = image_path + '/2.jpg';
          images[2] = image_path + '/3.jpg';
          images[3] = image_path + '/4.jpg';
    
    function displayNextImage() {
              x = (x === images.length - 1) ? 0 : x + 1;
             document.getElementById("detailsSlider").src = images[x];
          }

          function displayPreviousImage() {
              x = (x <= 0) ? images.length - 1 : x - 1;
              document.getElementById("detailsSlider").src = images[x];
          }

	    
         