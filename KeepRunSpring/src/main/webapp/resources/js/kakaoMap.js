	
	
	var IdGpsLat = 37.250674;
	var	IdGpsLng = 127.022816;

	if(document.getElementById("gpsLatitude0")!=null){
		IdGpsLat = document.getElementById("gpsLatitude0").value;
		IdGpsLng = document.getElementById("gpsLongitude0").value;
		
	}

	var mapContainer = document.getElementById('map'), 
		mapOption = { 
			center: new kakao.maps.LatLng(IdGpsLat, IdGpsLng), 
			level: 3
		};
	var map = new kakao.maps.Map(mapContainer, mapOption); 



	function addMarker(setLat,setLng){

		var markerPosition = new kakao.maps.LatLng(setLat, setLng);
		var marker = new kakao.maps.Marker({
			position:markerPosition
		});
		marker.setMap(map);
	}

	var gpsCount=document.getElementById("gpsCount").value;
	var lat=[];
	var lng=[];
	var gpsData = new Array();
	for(var i;i<gpsCount;i++){
		lat[i]=document.getElementById("gpsLatitude"+i).value;
		lng[i]=document.getElementById("gpsLongitude"+i).value;
		gpsData.push(new kakao.maps.LatLng(lat[i], lng[i]))
	}
	// var acoords=[];
	// var bcoords=[];
	// var distance=0;
	// for(var i; i<gpsCount-1;i++){
	// 	acoords[i] = { latitude : lat[i],longitude : lng[i]	};
	// 	bcoords[i] = { latitude : lat[i+1],longitude : lng[i+1]	};
	// 	distance = computeDistance(acoords[i],bcoords[i]);
	// 	console.log(distance);
	// }
	
	
	
	var linePath = gpsData;


	var polyline = new kakao.maps.Polyline({
		path: linePath, 
		strokeWeight: 5, // ���� �β� �Դϴ�
		strokeColor: '#FFAE00', // ���� �����Դϴ�
		strokeOpacity: 0.7, // ���� �������� �Դϴ� 1���� 0 ������ ���̸� 0�� �������� �����մϴ�
		strokeStyle: 'solid' // ���� ��Ÿ���Դϴ�
	});

	polyline.setMap(map); 
	 
