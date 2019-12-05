var mapContainer = document.getElementById('map'), 
    mapOption = { 
        center: new kakao.maps.LatLng(33.450701, 126.570667), 
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

	 var jsonArray = new Array();

	 var aJson = new Object();
	 aJson.lat = 33.452344169439975;
	 aJson.lng = 126.56878163224233;
	 jsonArray.push(aJson);
	
	 var bJson = new Object();
	 bJson.lat = 33.47;
	 bJson.lng = 126.56878163224233;
	 jsonArray.push(bJson);

	 var stringJson=JSON.stringify(jsonArray);
	////////////////////////////////////////////
	
	var obj = JSON.parse(stringJson);
	
	var gpsData = new Array();
	
	for(i in obj){
		gpsData.push(new kakao.maps.LatLng(obj[i].lat, obj[i].lng));
	};
	console.log(gpsData);
	
	var linePath = gpsData;


	var polyline = new kakao.maps.Polyline({
		path: linePath, 
		strokeWeight: 5, // ���� �β� �Դϴ�
		strokeColor: '#FFAE00', // ���� �����Դϴ�
		strokeOpacity: 0.7, // ���� �������� �Դϴ� 1���� 0 ������ ���̸� 0�� �������� �����մϴ�
		strokeStyle: 'solid' // ���� ��Ÿ���Դϴ�
	});

	polyline.setMap(map);  
