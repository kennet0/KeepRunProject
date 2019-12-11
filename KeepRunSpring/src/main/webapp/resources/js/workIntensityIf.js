function resultStatus(){
	console.log("wI"+document.getElementById("workIntensity").value)
	var workIntensity = parseInt(document.getElementById("workIntensity").value);
	var workResultStatus="";
	if(workIntensity<60){
		workResultStatus="Increase Work Intensity!"
	}else if (workIntensity>=60 && workIntensity<76){
		workResultStatus="Proper Work Intensity!"
	}else if (workIntensity>=76){
		workResultStatus="Overed Work Intensity!"
	}
	document.write(workResultStatus);
	return workResultStatus;
}

