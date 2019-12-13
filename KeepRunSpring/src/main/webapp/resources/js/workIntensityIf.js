function resultStatus(){
	console.log("wI"+document.getElementById("workIntensity").value)
	var workIntensity = parseInt(document.getElementById("workIntensity").value);
	var workResultStatus="";
	if(workIntensity<60){
		workResultStatus="운동 강도를 높이세요!!"
	}else if (workIntensity>=76){
		workResultStatus="너무 무리하셨어요!"
	}
	document.write(workResultStatus);
	return workResultStatus;
}

