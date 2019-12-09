// Set new default font family and font color to mimic Bootstrap's default styling
function chartPie(){
Chart.defaults.global.defaultFontFamily = 'Nunito', '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
Chart.defaults.global.defaultFontColor = '#858796';

  // Pie Chart Example
  var ctx = document.getElementById("myPieChart");

  var targetWeight= parseInt(document.getElementById("targetWeight").value);
  var currentWeight= parseInt(document.getElementById("currentWeight").value);
  var startWeight= parseInt(document.getElementById("startWeight").value);
    
    console.log(document.getElementById("currentWeight").value);


  var myPieChart = new Chart(ctx, {
    type: 'doughnut',
    data: {
      labels: ["Remained Weight", "Current Weight"],
      datasets: [{
        data: [currentWeight-targetWeight,startWeight-currentWeight],
        backgroundColor: ['#4e73df', '#1cc88a', '#36b9cc'],
        hoverBackgroundColor: ['#2e59d9', '#17a673', '#2c9faf'],
        hoverBorderColor: "rgba(234, 236, 244, 1)",
      }],
    },
    options: {
      maintainAspectRatio: false,
      tooltips: {
        backgroundColor: "rgb(255,255,255)",
        bodyFontColor: "#858796",
        borderColor: '#dddfeb',
        borderWidth: 1,
        xPadding: 15,
        yPadding: 15,
        displayColors: false,
        caretPadding: 10,
      },
      legend: {
        display: false
      },
      cutoutPercentage: 80,
    },
  });
}