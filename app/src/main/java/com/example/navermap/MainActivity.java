package com.example.navermap;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.UiThread;

import androidx.fragment.app.FragmentActivity;

import com.naver.maps.geometry.LatLng;
import com.naver.maps.map.CameraUpdate;
import com.naver.maps.map.MapFragment;
import com.naver.maps.map.NaverMap;
import com.naver.maps.map.OnMapReadyCallback;
import com.naver.maps.map.overlay.InfoWindow;
import com.naver.maps.map.overlay.Marker;



public class MainActivity extends FragmentActivity implements OnMapReadyCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //지도를 출렬할 프러그먼트 영역 인식
        MapFragment mapFragment = (MapFragment) getSupportFragmentManager().findFragmentById(R.id.map);

        if (mapFragment == null) {
            mapFragment = MapFragment.newInstance();
            getSupportFragmentManager().beginTransaction().add(R.id.map, mapFragment).commit();
        }

        mapFragment.getMapAsync( this);
    }

        @UiThread
        @Override


        public void onMapReady(@NonNull NaverMap naverMap){
            naverMap.setMapType(NaverMap.MapType.Basic);

            //심벌 크기
            naverMap.setSymbolScale(1.5f);

            //각 지점의 위도, 경도
            LatLng latLng1 = new LatLng(37.369 , 126.664);
            LatLng latLng2 = new LatLng(37.3932 , 126.7302);
            LatLng latLng3 = new LatLng(37.3959 , 126.7289);


            //지도 크기
            CameraUpdate cameraUpdate11 = CameraUpdate.zoomTo(12);
            naverMap.moveCamera(cameraUpdate11);

            Button button1 = (Button)findViewById(R.id.button1);
            button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    CameraUpdate cameraUpdate1 = CameraUpdate.scrollTo(latLng1);
                    naverMap.moveCamera(cameraUpdate1);

                    Marker marker1 = new Marker();
                    marker1.setPosition(latLng1);
                    marker1.setMap(naverMap);

                    marker1.setSubCaptionText("인천재능대");
                    marker1.setSubCaptionColor(Color.RED);
                    marker1.setSubCaptionHaloColor(Color.YELLOW);
                    marker1.setSubCaptionTextSize(10);

                    InfoWindow infoWindow1 = new InfoWindow();
                    infoWindow1.setAdapter(new InfoWindow.DefaultTextAdapter(getApplication()) {
                        @NonNull
                        @Override
                        public CharSequence getText(@NonNull InfoWindow infoWindow) {
                            return "나의 위치";
                        }
                    });
                    infoWindow1.open(marker1);
                }
            });


            //매장2
            Button button2 = (Button)findViewById(R.id.button2);
            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    CameraUpdate cameraUpdate1 = CameraUpdate.scrollTo(latLng2);
                    naverMap.moveCamera(cameraUpdate1);

                    Marker marker2 = new Marker();
                    marker2.setPosition(latLng2);
                    marker2.setMap(naverMap);

                    marker2.setSubCaptionText("우리집");
                    marker2.setSubCaptionColor(Color.RED);
                    marker2.setSubCaptionHaloColor(Color.YELLOW);
                    marker2.setSubCaptionTextSize(10);

                    InfoWindow infoWindow1 = new InfoWindow();
                    infoWindow1.setAdapter(new InfoWindow.DefaultTextAdapter(getApplication()) {
                        @NonNull
                        @Override
                        public CharSequence getText(@NonNull InfoWindow infoWindow) {
                            return "우리집";
                        }
                    });
                    infoWindow1.open(marker2);
                }
            });

            //학교3
            Button button3 = (Button)findViewById(R.id.button3);
            button3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    CameraUpdate cameraUpdate1 = CameraUpdate.scrollTo(latLng3);
                    naverMap.moveCamera(cameraUpdate1);

                    Marker marker3 = new Marker();
                    marker3.setPosition(latLng3);
                    marker3.setMap(naverMap);

                    marker3.setSubCaptionText("은계호수공원");
                    marker3.setSubCaptionColor(Color.RED);
                    marker3.setSubCaptionHaloColor(Color.YELLOW);
                    marker3.setSubCaptionTextSize(10);

                    InfoWindow infoWindow1 = new InfoWindow();
                    infoWindow1.setAdapter(new InfoWindow.DefaultTextAdapter(getApplication()) {
                        @NonNull
                        @Override
                        public CharSequence getText(@NonNull InfoWindow infoWindow) {
                            return "공원";
                        }
                    });
                    infoWindow1.open(marker3);
                }
            });

        }


    }