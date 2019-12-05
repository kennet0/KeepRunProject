

var mapContainer = document.getElementById('map'), 
    mapOption = { 
        center: new kakao.maps.LatLng(37.250674, 127.022816), 
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
	
	
	var linePath = gpsData;


	var polyline = new kakao.maps.Polyline({
		path: linePath, 
		strokeWeight: 5, // ���� �β� �Դϴ�
		strokeColor: '#FFAE00', // ���� �����Դϴ�
		strokeOpacity: 0.7, // ���� �������� �Դϴ� 1���� 0 ������ ���̸� 0�� �������� �����մϴ�
		strokeStyle: 'solid' // ���� ��Ÿ���Դϴ�
	});

	polyline.setMap(map); 
	 
