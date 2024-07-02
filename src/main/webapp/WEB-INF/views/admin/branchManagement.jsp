<%@ page contentType="text/html; charset=UTF-8"%>

<!-- header.jsp 내용 -->
<jsp:include page="/WEB-INF/views/common/header.jsp" />


		<div id="container" class="reservation_wrap">
			<div class="sub_visual">
				<div class="sub_visual_bg" style="background-image:url('https://www.junohair.com/static_resources/images/junohair/sub/reservation/reser_visual.jpg')"></div>
				<div class="sub_visual_text">
					<strong>RESERVATION</strong>
					<p class="sub_visual_sub_text">
						<span>실시간 매장 예약을 통해 <br class="m">편리한 매장 이용을 도와드리며,</span><br>
						<span>AI기반의 디자이너 추천 기능을 제공합니다.</span>
					</p>
				</div>
			</div>
			
			<div id="contents" class="shop_list">
				<div class="reser_process">
					<ul>
						<li>
							<span class="num">01</span>

							<span>매장 선택</span>


						</li>
						<li style="cursor: pointer;" onclick="gotoPre()">
							<span class="num">02</span>

							<span>디자이너 선택</span>


						</li>
						<li class="current">
							<span class="num">03</span>
							<span>일정 및 시술 선택</span>
						</li>
						<li>
							<span class="num">04</span>
							<span>예약 확인</span>
						</li>
					</ul>
				</div>

				<div class="clear"></div>

				<div class="designer_namebox">
					<p class="profileimg">
					<img src="https://www.junohair.com/upload/designer/202007/cec23a1f4708444e8cb9e5c78a8dc744.jpg" alt="" class="profileimgsrc">	
					</p>
					<div class="infocont">
						<p class="ttl">정원 수석실장<em>-</em><span class="branch">가든강남구청역점</span></p>
						<p class="desc">자연스러움속 트랜디함을 만들어드립니다!</p>
					</div>
					<span class="line"></span>
				</div>
				<div class="schedule_box">
					<div class="calendar_wrap">
						<div class="head">
						    <a class="btn_prev" href="#juno" onclick="prevCal()"><span class="blind">이전</span></a>
						    <span class="title_month">2024.7</span>
						    <a class="btn_next" href="#juno" onclick="nextCal()"><span class="blind">다음</span></a>
						</div>
						<div class="calendarTable">
							<table border="0" cellpadding="0" cellspacing="0">
								<thead>
				                    <tr>
				                        <th class="sun">일</th>
				                        <th>월</th>
				                        <th>화</th>
				                        <th>수</th>
				                        <th>목</th>
				                        <th>금</th>
				                        <th class="sat">토</th>
				                    </tr>
				                </thead>
				                <tbody id="caltbody"><tr>	<td class="sun">	</td>	<td>	<span class="closeday" id="1_mon_1" day="1">1</span>	</td>	<td>	<a href="#juno" id="1_tue_2" onclick="selectDay(2)" day="2">2</a>	</td>	<td>	<a href="#juno" id="1_wed_3" onclick="selectDay(3)" day="3">3</a>	</td>	<td>	<a href="#juno" id="1_thu_4" onclick="selectDay(4)" day="4">4</a>	</td>	<td>	<a href="#juno" id="1_fri_5" onclick="selectDay(5)" day="5">5</a>	</td>	<td class="sat">	<a href="#juno" id="1_sat_6" onclick="selectDay(6)" day="6">6</a>	</td></tr><tr>	<td class="sun">	<a href="#juno" id="2_sun_7" onclick="selectDay(7)" day="7">7</a>	</td>	<td>	<span class="closeday" id="2_mon_8" day="8">8</span>	</td>	<td>	<a href="#juno" id="2_tue_9" onclick="selectDay(9)" day="9">9</a>	</td>	<td>	<a href="#juno" id="2_wed_10" onclick="selectDay(10)" day="10">10</a>	</td>	<td>	<a href="#juno" id="2_thu_11" onclick="selectDay(11)" day="11">11</a>	</td>	<td>	<a href="#juno" id="2_fri_12" onclick="selectDay(12)" day="12">12</a>	</td>	<td class="sat">	<a href="#juno" id="2_sat_13" onclick="selectDay(13)" day="13">13</a>	</td></tr><tr>	<td class="sun">	<a href="#juno" id="3_sun_14" onclick="selectDay(14)" day="14">14</a>	</td>	<td>	<span class="closeday" id="3_mon_15" day="15">15</span>	</td>	<td>	<a href="#juno" id="3_tue_16" onclick="selectDay(16)" day="16">16</a>	</td>	<td>	<a href="#juno" id="3_wed_17" onclick="selectDay(17)" day="17">17</a>	</td>	<td>	<a href="#juno" id="3_thu_18" onclick="selectDay(18)" day="18">18</a>	</td>	<td>	<a href="#juno" id="3_fri_19" onclick="selectDay(19)" day="19">19</a>	</td>	<td class="sat">	<a href="#juno" id="3_sat_20" onclick="selectDay(20)" day="20">20</a>	</td></tr><tr>	<td class="sun">	<a href="#juno" id="4_sun_21" onclick="selectDay(21)" day="21">21</a>	</td>	<td>	<span class="closeday" id="4_mon_22" day="22">22</span>	</td>	<td>	<a href="#juno" id="4_tue_23" onclick="selectDay(23)" day="23">23</a>	</td>	<td>	<a href="#juno" id="4_wed_24" onclick="selectDay(24)" day="24">24</a>	</td>	<td>	<a href="#juno" id="4_thu_25" onclick="selectDay(25)" day="25">25</a>	</td>	<td>	<a href="#juno" id="4_fri_26" onclick="selectDay(26)" day="26">26</a>	</td>	<td class="sat">	<a href="#juno" id="4_sat_27" onclick="selectDay(27)" day="27">27</a>	</td></tr><tr>	<td class="sun">	<a href="#juno" id="5_sun_28" onclick="selectDay(28)" day="28">28</a>	</td>	<td>	<span class="closeday" id="5_mon_29" day="29">29</span>	</td>	<td>	<a href="#juno" id="5_tue_30" onclick="selectDay(30)" day="30">30</a>	</td>	<td>	<a href="#juno" id="5_wed_31" onclick="selectDay(31)" day="31">31</a>	</td>	<td>	</td>	<td>	</td>	<td class="sat">	</td></tr></tbody>
							</table>
							<div class="noti">
								<p><span>선택</span></p>
								<p><span>불가</span></p>
							</div>
						</div>
					</div>
					<div class="timeselectbox">
						<div class="dateTime">
							<p class="tit">날짜</p>
							<p class="txt" id="dateTimeTxt">2024.7.1(월)</p>
						</div>
						<div class="dateTime">
							<p class="tit">시간</p>
							<p class="timeselect" id="timeselect">시간을 선택해주세요.</p>
							<p class="m_timeselect" id="m_timeselect"><a href="">시간을 선택해주세요.</a></p>
						</div>
						<div class="timeline" id="timeline"></div>
					</div>
				</div>
				<div class="sisul_categorybox">

					<div class="sisul_category cover_scroll">
						<ul>
							<li class="active"><a href="#juno" id="shampu" onclick="selectSisulCategory('shampu')">샴푸</a></li>
							<li><a href="#juno" id="dry" onclick="selectSisulCategory('dry')">드라이</a></li>
							<li><a href="#juno" id="cut" onclick="selectSisulCategory('cut')">커트</a></li>
							<li><a href="#juno" id="perm" onclick="selectSisulCategory('perm')">펌</a></li>
							<li><a href="#juno" id="color" onclick="selectSisulCategory('color')">컬러</a></li>
							<li><a href="#juno" id="clinic" onclick="selectSisulCategory('clinic')">클리닉</a></li>
							<li><a href="#juno" id="headspa" onclick="selectSisulCategory('headspa')">헤드스파</a></li>
						</ul>
						<span class="cover left"></span>
						<span class="cover right"></span>
					</div>
					
				</div>

				<div class="sisul_category_detail sisul_cate_items">
					<ul id="sisuldetails"><li>	<span class="check_type">		<input type="checkbox" id="35c3358b1df396df765f57780b57f710" class="checkbox" onclick="sisulCheckboxOnclick(this);">		<label for="35c3358b1df396df765f57780b57f710">릴렉싱 샴푸</label>	</span>	<div class="pricezone">		<p class="current">20,000<span class="won">원</span></p>	</div></li><li>	<span class="check_type">		<input type="checkbox" id="118170444885ba63df355aa31769bcf9" class="checkbox" onclick="sisulCheckboxOnclick(this);">		<label for="118170444885ba63df355aa31769bcf9">성형 샴푸</label>	</span>	<div class="pricezone">		<p class="current">30,000<span class="won">원</span></p>	</div></li><li>	<span class="check_type">		<input type="checkbox" id="7d5336290f25d6c4c6d1c273f9754d35" class="checkbox" onclick="sisulCheckboxOnclick(this);">		<label for="7d5336290f25d6c4c6d1c273f9754d35">붙임머리 샴푸</label>	</span>	<div class="pricezone">		<p class="current">40,000<span class="won">원</span></p>	</div></li></ul>
				</div>
				
				<div class="recomm_sisul" id="recomm_sisul" style="display: none;">
				</div>

				<div class="forecast_sisul" style="display:none">
					<div class="box">
						<p class="ttl">선택 내역</p>
						<div class="mysisul">
							<ul id="mysisullist">
							</ul>
						</div>
					</div>
				</div>
				<div class="sisul_textbox">
					<textarea id="orderMemo" placeholder="요청사항을 입력하세요 (150자 이내)"></textarea>
				</div>
				<div class="ai_foot_btns">
					<a href="javascript:gotoPre();" class="btnbox_line" onclick="gotoPre()">이전</a>
					<a href="#juno" class="btnbox_black" onclick="gotoNext()">다음</a>
				</div>
			</div>
			
		</div>
		
	<!-- footer.jsp 내용 -->
	<jsp:include page="/WEB-INF/views/common/footer.jsp" />
	
	</div>
	<div class="loading" style="display: none;">
		<div class="loading_inner">
			<img src="https://www.junohair.com/static_resources/images/gate_img1.png" alt="JUNO HAIR">
			<p>시간스케줄을 로딩중 입니다..</p>
			<div class="loading_dots">
				<span class="loading_dot"></span>
				<span class="loading_dot"></span>
				<span class="loading_dot"></span>
				<span class="loading_dot"></span>
				<span class="loading_dot"></span>
			</div>
		</div>
	</div>
<script>


		
var holidayData = [ {
  "sun" : "N",
  "mon" : "Y",
  "tue" : "N",
  "wed" : "N",
  "thu" : "N",
  "fri" : "N",
  "sat" : "N"
}, {
  "sun" : "N",
  "mon" : "Y",
  "tue" : "N",
  "wed" : "N",
  "thu" : "N",
  "fri" : "N",
  "sat" : "N"
}, {
  "sun" : "N",
  "mon" : "Y",
  "tue" : "N",
  "wed" : "N",
  "thu" : "N",
  "fri" : "N",
  "sat" : "N"
}, {
  "sun" : "N",
  "mon" : "Y",
  "tue" : "N",
  "wed" : "N",
  "thu" : "N",
  "fri" : "N",
  "sat" : "N"
}, {
  "sun" : "N",
  "mon" : "Y",
  "tue" : "N",
  "wed" : "N",
  "thu" : "N",
  "fri" : "N",
  "sat" : "N"
}, {
  "sun" : "N",
  "mon" : "Y",
  "tue" : "N",
  "wed" : "N",
  "thu" : "N",
  "fri" : "N",
  "sat" : "N"
} ]
var sisulShampuList = [ {
  "id" : "35c3358b1df396df765f57780b57f710",
  "sisulId" : "24ad48bab64d4e4fabd6912a6369ff02",
  "sisulDesc" : "릴렉싱 샴푸",
  "price" : "20,000",
  "priceDiscount" : "",
  "discountYn" : false,
  "recommendSisulId" : "",
  "sort" : 1
}, {
  "id" : "118170444885ba63df355aa31769bcf9",
  "sisulId" : "24ad48bab64d4e4fabd6912a6369ff02",
  "sisulDesc" : "성형 샴푸",
  "price" : "30,000",
  "priceDiscount" : "",
  "discountYn" : false,
  "recommendSisulId" : "",
  "sort" : 2
}, {
  "id" : "7d5336290f25d6c4c6d1c273f9754d35",
  "sisulId" : "24ad48bab64d4e4fabd6912a6369ff02",
  "sisulDesc" : "붙임머리 샴푸",
  "price" : "40,000",
  "priceDiscount" : "",
  "discountYn" : false,
  "recommendSisulId" : "",
  "sort" : 3
} ]
var sisulDryList = [ {
  "id" : "fb605541afe4eb58aed92b42e0b63b03",
  "sisulId" : "b0109fa60f074135a219b0cc0c0b8170",
  "sisulDesc" : "블로우 드라이",
  "price" : "35,000",
  "priceDiscount" : "",
  "discountYn" : false,
  "recommendSisulId" : "",
  "sort" : 1
}, {
  "id" : "8955f534f9ec9f94268ad2228e35741e",
  "sisulId" : "b0109fa60f074135a219b0cc0c0b8170",
  "sisulDesc" : "아이롱 드라이",
  "price" : "45,000",
  "priceDiscount" : "",
  "discountYn" : false,
  "recommendSisulId" : "",
  "sort" : 2
}, {
  "id" : "510b8aa214d946d135b4aa033a47f327",
  "sisulId" : "b0109fa60f074135a219b0cc0c0b8170",
  "sisulDesc" : "붙임머리 드라이",
  "price" : "70,000",
  "priceDiscount" : "",
  "discountYn" : false,
  "recommendSisulId" : "",
  "sort" : 3
}, {
  "id" : "f469d198dd350b938afced608d0bd922",
  "sisulId" : "b0109fa60f074135a219b0cc0c0b8170",
  "sisulDesc" : "남성 스타일링",
  "price" : "20,000",
  "priceDiscount" : "",
  "discountYn" : false,
  "recommendSisulId" : "",
  "sort" : 4
} ]
var sisulCutList = [ {
  "id" : "22c03bfcb95d7d22ddcc0781ebef2e4d",
  "sisulId" : "14b3341ceae44eddad06f20211e55506",
  "sisulDesc" : "앞머리 커트",
  "price" : "15,000",
  "priceDiscount" : "",
  "discountYn" : false,
  "recommendSisulId" : "",
  "sort" : 1
}, {
  "id" : "88932b8e7655a47087cc9cafebe4b9d6",
  "sisulId" : "14b3341ceae44eddad06f20211e55506",
  "sisulDesc" : "주니어 커트",
  "price" : "25,000",
  "priceDiscount" : "",
  "discountYn" : false,
  "recommendSisulId" : "",
  "sort" : 2
}, {
  "id" : "8f643a602afd813679952aa5ddf90d3a",
  "sisulId" : "14b3341ceae44eddad06f20211e55506",
  "sisulDesc" : "디자인 커트",
  "price" : "35,000",
  "priceDiscount" : "",
  "discountYn" : false,
  "recommendSisulId" : "",
  "sort" : 3
}, {
  "id" : "c7c972e51f04d5c751159a9ed4801fa8",
  "sisulId" : "14b3341ceae44eddad06f20211e55506",
  "sisulDesc" : "스켈링 커트",
  "price" : "75,000",
  "priceDiscount" : "",
  "discountYn" : false,
  "recommendSisulId" : "",
  "sort" : 4
} ]
var sisulPermList = [ {
  "id" : "2fbd9558feaa454e1299f79da8caa385",
  "sisulId" : "cd2fd43703e34b42b63717a2e0ead06c",
  "sisulDesc" : "남성 베이직펌",
  "price" : "165,000",
  "priceDiscount" : "",
  "discountYn" : false,
  "recommendSisulId" : "",
  "sort" : 1
}, {
  "id" : "42a7301af0b56a4eb3c91c46811157bd",
  "sisulId" : "cd2fd43703e34b42b63717a2e0ead06c",
  "sisulDesc" : "여성 베이직펌",
  "price" : "200,000",
  "priceDiscount" : "",
  "discountYn" : false,
  "recommendSisulId" : "",
  "sort" : 2
}, {
  "id" : "2a6a574bcc6893545ee9d182506a7f2a",
  "sisulId" : "cd2fd43703e34b42b63717a2e0ead06c",
  "sisulDesc" : "셋팅 / 디지털 펌",
  "price" : "280,000",
  "priceDiscount" : "",
  "discountYn" : false,
  "recommendSisulId" : "",
  "sort" : 3
}, {
  "id" : "d9fb5a48a951c0f54a8d2277d393195c",
  "sisulId" : "cd2fd43703e34b42b63717a2e0ead06c",
  "sisulDesc" : "매직셋팅",
  "price" : "330,000",
  "priceDiscount" : "",
  "discountYn" : false,
  "recommendSisulId" : "",
  "sort" : 4
}, {
  "id" : "dc6c1e4d91c00cd8870ecc0517aee593",
  "sisulId" : "cd2fd43703e34b42b63717a2e0ead06c",
  "sisulDesc" : "다운펌",
  "price" : "40,000",
  "priceDiscount" : "",
  "discountYn" : false,
  "recommendSisulId" : "",
  "sort" : 5
}, {
  "id" : "4b906b09418ae6fb5ad4fd616d791545",
  "sisulId" : "cd2fd43703e34b42b63717a2e0ead06c",
  "sisulDesc" : "앞머리펌 / 부분펌",
  "price" : "44,000",
  "priceDiscount" : "",
  "discountYn" : false,
  "recommendSisulId" : "",
  "sort" : 6
} ]
var sisulColorList = [ {
  "id" : "9df297ae72d02c27253f9f4ddc693d82",
  "sisulId" : "a640e8a9adc641949133642778707a14",
  "sisulDesc" : "리터치",
  "price" : "120,000",
  "priceDiscount" : "",
  "discountYn" : false,
  "recommendSisulId" : "",
  "sort" : 1
}, {
  "id" : "cfb05931e34d53cddafb130523a01a69",
  "sisulId" : "a640e8a9adc641949133642778707a14",
  "sisulDesc" : "베이직 염색",
  "price" : "165,000",
  "priceDiscount" : "",
  "discountYn" : false,
  "recommendSisulId" : "",
  "sort" : 2
}, {
  "id" : "234f81604e928a507971ea8eeb2bed53",
  "sisulId" : "a640e8a9adc641949133642778707a14",
  "sisulDesc" : "탈색",
  "price" : "187,000",
  "priceDiscount" : "",
  "discountYn" : false,
  "recommendSisulId" : "",
  "sort" : 3
}, {
  "id" : "b7c3e27e2eeb4affb3e1ae1906e57de3",
  "sisulId" : "a640e8a9adc641949133642778707a14",
  "sisulDesc" : "매니큐어",
  "price" : "165,000",
  "priceDiscount" : "",
  "discountYn" : false,
  "recommendSisulId" : "",
  "sort" : 4
}, {
  "id" : "a9cb833ae86f8cec4b5e4dc6bba48f4a",
  "sisulId" : "a640e8a9adc641949133642778707a14",
  "sisulDesc" : "하이라이트",
  "price" : "187,000",
  "priceDiscount" : "",
  "discountYn" : false,
  "recommendSisulId" : "",
  "sort" : 5
} ]
var sisulClinicList = [ {
  "id" : "4a06e5a18ebd8b37a103c1122bc03361",
  "sisulId" : "b37a96feb9e041128ac70d8ec5b46f1c",
  "sisulDesc" : "이너 케어",
  "price" : "150,000",
  "priceDiscount" : "",
  "discountYn" : false,
  "recommendSisulId" : "",
  "sort" : 1
}, {
  "id" : "9ec54192a6275cf92c44d3143a7f86ae",
  "sisulId" : "b37a96feb9e041128ac70d8ec5b46f1c",
  "sisulDesc" : "인-아웃 케어",
  "price" : "200,000",
  "priceDiscount" : "",
  "discountYn" : false,
  "recommendSisulId" : "",
  "sort" : 2
}, {
  "id" : "194d382e6627cf13453187caf1ab472c",
  "sisulId" : "b37a96feb9e041128ac70d8ec5b46f1c",
  "sisulDesc" : "프리미엄 케어",
  "price" : "250,000",
  "priceDiscount" : "",
  "discountYn" : false,
  "recommendSisulId" : "",
  "sort" : 3
} ]
var sisulHeadspaList = [ {
  "id" : "53549336c45ea4303b76a5c4bc33f1b9",
  "sisulId" : "aa5d83e3f8744740b6708336ab94f7a8",
  "sisulDesc" : "두피 케어",
  "price" : "150,000",
  "priceDiscount" : "",
  "discountYn" : false,
  "recommendSisulId" : "",
  "sort" : 1
} ]
var sisulAllList = sisulShampuList.concat(sisulDryList.concat(sisulCutList.concat(sisulPermList.concat(sisulColorList.concat(sisulClinicList.concat(sisulHeadspaList))))));
var selectedSisullist = [];
var totalamt;
var rdate;
var ryoil;
var rtime24;
var rtime;
var rampm;

$(document).ready(function(){
	
	todayCal();
	if(sisulShampuList.length != 0){
		selectSisulCategory("shampu");
	} else if(sisulDryList.length != 0){
		selectSisulCategory("dry");
	} else if(sisulCutList.length != 0){
		selectSisulCategory("cut");
	} else if(sisulPermList.length != 0){
		selectSisulCategory("perm");
	} else if(sisulColorList.length != 0){
		selectSisulCategory("color");
	} else if(sisulClinicList.length != 0){
		selectSisulCategory("clinic");
	} else {
		selectSisulCategory("headspa");
	}
})


function selectSisulCategory(sisulCategory){
	var sisulCategoryList = $("#"+sisulCategory).parent().parent().find("li");
	for(var i=0; i<sisulCategoryList.length; i++){
		$(sisulCategoryList[i]).removeClass("active");
	}
	$("#"+sisulCategory).parent().addClass("active");
	
	var sisulList = [];
	if(sisulCategory === "shampu"){
		sisulList = sisulShampuList;
	} else if(sisulCategory === "dry"){
		sisulList = sisulDryList;
	} else if(sisulCategory === "cut"){
		sisulList = sisulCutList;
	} else if(sisulCategory === "perm"){
		sisulList = sisulPermList;
	} else if(sisulCategory === "color"){
		sisulList = sisulColorList;
	} else if(sisulCategory === "clinic"){
		sisulList = sisulClinicList;
	} else if(sisulCategory === "headspa"){
		sisulList = sisulHeadspaList;
	}
	
	$("#sisuldetails").html("");
	var sisulListHtml = "";
	if(sisulList.length > 0){
		for(var i=0; i<sisulList.length; i++){
			sisulListHtml += '<li>';
			sisulListHtml += '	<span class="check_type">';
			sisulListHtml += '		<input type="checkbox" id="' + sisulList[i].id + '" class="checkbox" onclick="sisulCheckboxOnclick(this);"/>';
			sisulListHtml += '		<label for="' + sisulList[i].id + '">' + sisulList[i].sisulDesc + '</label>';
			sisulListHtml += '	</span>';
			sisulListHtml += '	<div class="pricezone">';
			if(sisulList[i].discountYn){
				sisulListHtml += '		<p class="saleprice">';
				sisulListHtml += '			<span class="original">' + sisulList[i].price + '</span>';
				sisulListHtml += '			<span class="sale">' + (100 - parseInt(Number(sisulList[i].priceDiscount.replaceAll(",","")) /  Number(sisulList[i].price.replaceAll(",","")) * 100)) + '% 할인</span>';
				sisulListHtml += '		</p>';
				sisulListHtml += '		<p class="current">' + sisulList[i].priceDiscount + '<span class="won">원</span></p>';
				sisulListHtml += '	</div>';
				sisulListHtml += '</li>';
			} else {
				sisulListHtml += '		<p class="current">' + sisulList[i].price + '<span class="won">원</span></p>';
				sisulListHtml += '	</div>';
				sisulListHtml += '</li>';
			}
		}	
	} else {
		sisulListHtml += '<li class="full">시술 항목이 없습니다.</li> <!-- 2020-06-14 수정-->';
	}

	$("#sisuldetails").html(sisulListHtml);
	
	// 각 시술상세의 체크박스 체크처리하기
	for(var i=0; i<sisulAllList.length; i++){
		if(sisulAllList[i].chk === true){
			$("input:checkbox[id='"+ sisulAllList[i].id +"']").prop("checked", true)
		}
	}

	//스크롤 커버
	var coverScroll = {};
	$.extend(coverScroll,{
		init : function(){
			$('.cover_scroll ul').scroll(function(){
				var navW = 0,
				li = $(this).find('li'),
				conW = $(this).width(),
				scrollLeft = $(this).scrollLeft();
				for(var i = 0; i < li.length; i++){
					navW += li.eq(i).width();
				}
				if ( scrollLeft == 0 ){
					$(this).parent().find('.cover.left').hide();
					$(this).parent().find('.cover.right').show();
				} else if ( scrollLeft > ( navW - conW ) ) {
					$(this).parent().find('.cover.right').hide();
					$(this).parent().find('.cover.left').show();
				} else {
					$(this).parent().find('.cover.right').show();
					$(this).parent().find('.cover.left').show();
				}
			});
		}
	}).init();
}

function sisulCheckboxOnclick(obj){
	var sisulid = $(obj).attr('id');
	if ( $(obj).prop('checked')){
		for(var i=0; i<sisulAllList.length; i++){
			if(sisulid === sisulAllList[i].id){
				sisulAllList[i].chk = true;
				// 선택된 시술상세 리스트(selectedSisullist)에 추가를 한다.
				selectedSisullist.push(sisulAllList[i]);
				recommendSisul(sisulAllList[i])
				break;
			}
		}
	} else {
		for(var i=0; i<sisulAllList.length; i++){
			if(sisulid === sisulAllList[i].id){
				sisulAllList[i].chk = false;
				// 선택된 시술상세 리스트(selectedSisullist)에서 삭제를 한다.
				for(var j=0; j<selectedSisullist.length; j++){
					if(sisulid === selectedSisullist[j].id){
						selectedSisullist.splice(j,1);
						$("#recomm_sisul").html("");
						break;
					}
				}
				break;
			}
		}
	}
	// 선택내역란 영역을 셋팅한다.
	setMysisulArea();
}

function recommendSisul(data){
	if(data.recommendSisulId == ""){
		$("#recomm_sisul").html("");
		$("#recomm_sisul").hide();
		return;
	}
	
	var recommSisul;
	for(var i=0; i<sisulAllList.length; i++){
		if(data.recommendSisulId === sisulAllList[i].id){
			recommSisul = sisulAllList[i];
			break;
		}
	}
	if(recommSisul === undefined){
		$("#recomm_sisul").html("");
		$("#recomm_sisul").hide();
		return;
	}
	
	var recomm_sisul_html = '';
	recomm_sisul_html += '<div class="ttlbox">';
	recomm_sisul_html += '	<p class="ttl">임경민님의 <span>추천 시술</span></p>';
	recomm_sisul_html += '</div>';
	recomm_sisul_html += '<div class="sisul_category_detail">';
	recomm_sisul_html += '	<ul>';
	recomm_sisul_html += '		<li>';
	recomm_sisul_html += '			<span class="check_type">';
	recomm_sisul_html += '				<input type="checkbox" id="recomm_' + recommSisul.id + '" name="detailsisul" class="checkbox" onclick="recommSisulCheckboxOnclick(this)">';
	recomm_sisul_html += '				<label for="recomm_' + recommSisul.id + '">' + recommSisul.sisulDesc + '</label>';
	recomm_sisul_html += '			</span>';
	recomm_sisul_html += '			<div class="pricezone">';
	if(recommSisul.discountYn){
		recomm_sisul_html += '				<p class="saleprice">';
		recomm_sisul_html += '					<span class="original">' + recommSisul.price + '</span>';
		recomm_sisul_html += '					<span class="sale">' + (100 - parseInt(Number(recommSisul.priceDiscount.replaceAll(",","")) /  Number(recommSisul.price.replaceAll(",","")) * 100)) + '</span>';
		recomm_sisul_html += '				</p>';
		recomm_sisul_html += '				<p class="current">' + recommSisul.priceDiscount + '<span class="won">원</span></p>';
	} else {
		recomm_sisul_html += '				<p class="current">' + recommSisul.price + '<span class="won">원</span></p>';
	}
	recomm_sisul_html += '			</div>';
	recomm_sisul_html += '		</li>';
	recomm_sisul_html += '	</ul>';
	recomm_sisul_html += '</div>';
	
	$("#recomm_sisul").html(recomm_sisul_html);
	$("#recomm_sisul").show();
	
	// 이미 체크되어있는 대상인지 확인하고 체크처리
	for(var i=0; i<sisulAllList.length; i++){
		if(sisulAllList[i].chk === true){
			$("input:checkbox[id='recomm_"+ sisulAllList[i].id +"']").prop("checked", true)
		}
	}
}

function recommSisulCheckboxOnclick(obj){
	var sisulid = $(obj).attr('id').substr(7)
	if ( $(obj).prop('checked')){
		for(var i=0; i<sisulAllList.length; i++){
			if(sisulid === sisulAllList[i].id){
				sisulAllList[i].chk = true;
				// 선택된 시술상세 리스트(selectedSisullist)에 추가를 한다.
				selectedSisullist.push(sisulAllList[i]);
				break;
			}
		}
	} else {
		for(var i=0; i<sisulAllList.length; i++){
			if(sisulid === sisulAllList[i].id){
				sisulAllList[i].chk = false;
				// 선택된 시술상세 리스트(selectedSisullist)에서 삭제를 한다.
				for(var j=0; j<selectedSisullist.length; j++){
					if(sisulid === selectedSisullist[j].id){
						selectedSisullist.splice(j,1);
						break;
					}
				}
				break;
			}
		}
	}
	// 선택내역란 영역을 셋팅한다.
	setMysisulArea();
}

//선택내역란 영역을 셋팅한다.
function setMysisulArea(){
	$("#mysisullist").html("");
	var mysisullisthtml = "";
	totalamt = 0;
	for(var i=0; i<selectedSisullist.length; i++){
		mysisullisthtml += '<li>';
		mysisullisthtml += '	<span class="tit">' + selectedSisullist[i].sisulDesc + '</span>';
		mysisullisthtml += '	<a href="#juno" class="delete" onclick="removeSelectedSisul(\'' + selectedSisullist[i].id + '\')">삭제</a>';
		if(selectedSisullist[i].discountYn){
			mysisullisthtml += '<p class="price">' + selectedSisullist[i].priceDiscount + '<span class="won">원</span></p>';
			totalamt += Number(selectedSisullist[i].priceDiscount.replaceAll(",",""));
		} else {
			mysisullisthtml += '<p class="price">' + selectedSisullist[i].price + '<span class="won">원</span></p>';
			totalamt += Number(selectedSisullist[i].price.replaceAll(",",""));
		}
		mysisullisthtml += '</li>';
	}
	mysisullisthtml += '	<li class="total">';
	mysisullisthtml += '		<span class="tit">예상금액</span>';
	mysisullisthtml += '		<p class="price">' + totalamt.numformat() + '<span class="won">원</span></p>';
	mysisullisthtml += '	</li>';
	$("#mysisullist").html(mysisullisthtml);
	
	// 만약 총 예상금액이 0원이면
	if(totalamt == 0){
		$('.forecast_sisul').hide();
	} else {
		$('.forecast_sisul').show();
	}
}

function removeSelectedSisul(sisulid){
	$("input:checkbox[id='"+ sisulid +"']").prop("checked", false);
	var flag = false;
	for(var i=0; i<sisulShampuList.length; i++){
		if(sisulShampuList[i].id === sisulid){
			sisulShampuList[i].chk = false;
			flag = true;
			break;
		}
	}
	if(!flag){
		for(var i=0; i<sisulDryList.length; i++){
			if(sisulDryList[i].id === sisulid){
				sisulDryList[i].chk = false;
				flag = true;
				break;
			}
		}
	}
	if(!flag){
		for(var i=0; i<sisulCutList.length; i++){
			if(sisulCutList[i].id === sisulid){
				sisulCutList[i].chk = false;
				flag = true;
				break;
			}
		}
	}
	if(!flag){
		for(var i=0; i<sisulPermList.length; i++){
			if(sisulPermList[i].id === sisulid){
				sisulPermList[i].chk = false;
				flag = true;
				break;
			}
		}
	}
	if(!flag){
		for(var i=0; i<sisulColorList.length; i++){
			if(sisulColorList[i].id === sisulid){
				sisulColorList[i].chk = false;
				flag = true;
				break;
			}
		}
	}
	if(!flag){
		for(var i=0; i<sisulClinicList.length; i++){
			if(sisulClinicList[i].id === sisulid){
				sisulClinicList[i].chk = false;
				flag = true;
				break;
			}
		}
	}
	if(!flag){
		for(var i=0; i<sisulHeadspaList.length; i++){
			if(sisulHeadspaList[i].id === sisulid){
				sisulHeadspaList[i].chk = false;
				flag = true;
				break;
			}
		}
	}
	// 선택된 시술상세 리스트(selectedSisullist)에서 삭제를 한다.
	for(var i=0; i<selectedSisullist.length; i++){
		if(sisulid === selectedSisullist[i].id){
			selectedSisullist.splice(i,1);
			break;
		}
	}
	// 선택내역란 영역을 셋팅한다.
	setMysisulArea();
}

var calendarData;
function setCalendar(){
	$("#caltbody").html("");
	calendarData = buildCalendar();
	$(".title_month").text(calendarData.year + "." + calendarData.month);
	
	var valhtml = "";
	var sun, mon, tue, wed, thu, fri, sat;
	for(var i=0; i < calendarData.dayinfo.length; i++){
		sun = calendarData.dayinfo[i].sun === undefined ? "" : calendarData.dayinfo[i].sun;
		mon = calendarData.dayinfo[i].mon === undefined ? "" : calendarData.dayinfo[i].mon;
		tue = calendarData.dayinfo[i].tue === undefined ? "" : calendarData.dayinfo[i].tue;
		wed = calendarData.dayinfo[i].wed === undefined ? "" : calendarData.dayinfo[i].wed;
		thu = calendarData.dayinfo[i].thu === undefined ? "" : calendarData.dayinfo[i].thu;
		fri = calendarData.dayinfo[i].fri === undefined ? "" : calendarData.dayinfo[i].fri;
		sat = calendarData.dayinfo[i].sat === undefined ? "" : calendarData.dayinfo[i].sat;
		
		valhtml += '<tr>';
		valhtml += '	<td class="sun">';
		if(sun !== "") {
			if(holidayData[i].sun !== "Y"){
				valhtml += '	<a href="#juno" id="'+ String(i+1) + "_sun_" + sun + '" onclick="selectDay(' + sun + ')" day="' + sun + '">' + sun + '</a>';
			} else {
				valhtml += '	<span class="closeday" id="'+ String(i+1) + "_sun_" + sun + '" day="' + sun + '">' + sun + '</span>';
			}
		}				
		valhtml += '	</td>';
		valhtml += '	<td>';
		if(mon !== "") {
			if(holidayData[i].mon !== "Y"){
				valhtml += '	<a href="#juno" id="'+ String(i+1) + "_mon_" + mon + '" onclick="selectDay(' + mon + ')" day="' + mon + '">' + mon + '</a>';
			} else {
				valhtml += '	<span class="closeday" id="'+ String(i+1) + "_mon_" + mon + '" day="' + mon + '">' + mon + '</span>';
			}
		}
		valhtml += '	</td>';
		valhtml += '	<td>';
		if(tue !== "") {
			if(holidayData[i].tue !== "Y"){
				valhtml += '	<a href="#juno" id="'+ String(i+1) + "_tue_" + tue + '" onclick="selectDay(' + tue + ')" day="' + tue + '">' + tue + '</a>';
			} else {
				valhtml += '	<span class="closeday" id="'+ String(i+1) + "_tue_" + tue + '" day="' + tue + '">' + tue + '</span>';
			}
		}
		valhtml += '	</td>';
		valhtml += '	<td>';
		if(wed !== "") {
			if(holidayData[i].wed !== "Y"){
				valhtml += '	<a href="#juno" id="'+ String(i+1) + "_wed_" + wed + '" onclick="selectDay(' + wed + ')" day="' + wed + '">' + wed + '</a>';
			} else {
				valhtml += '	<span class="closeday" id="'+ String(i+1) + "_wed_" + wed + '" day="' + wed + '">' + wed + '</span>';
			}
		}
		valhtml += '	</td>';
		valhtml += '	<td>';
		if(thu !== "") {
			if(holidayData[i].thu !== "Y"){
				valhtml += '	<a href="#juno" id="'+ String(i+1) + "_thu_" + thu + '" onclick="selectDay(' + thu + ')" day="' + thu + '">' + thu + '</a>';
			} else {
				valhtml += '	<span class="closeday" id="'+ String(i+1) + "_thu_" + thu + '" day="' + thu + '">' + thu + '</span>';
			}
		}
		valhtml += '	</td>';
		valhtml += '	<td>';
		if(fri !== "") {
			if(holidayData[i].fri !== "Y"){
				valhtml += '	<a href="#juno" id="'+ String(i+1) + "_fri_" + fri + '" onclick="selectDay(' + fri + ')" day="' + fri + '">' + fri + '</a>';
			} else {
				valhtml += '	<span class="closeday" id="'+ String(i+1) + "_fri_" + fri + '" day="' + fri + '">' + fri + '</span>';
			}
		}
		valhtml += '	</td>';
		valhtml += '	<td class="sat">';
		if(sat !== "") {
			if(holidayData[i].sat !== "Y"){
				valhtml += '	<a href="#juno" id="'+ String(i+1) + "_sat_" + sat + '" onclick="selectDay(' + sat + ')" day="' + sat + '">' + sat + '</a>';
			} else {
				valhtml += '	<span class="closeday" id="'+ String(i+1) + "_sat_" + sat + '" day="' + sat + '">' + sat + '</span>';
			}
		}
		valhtml += '	</td>';
		valhtml += '</tr>';
	}
	$("#caltbody").html(valhtml);
}

var oldSelectedDay;
function selectDay(day){
	
	
	$("#timeselect").removeClass("active");
	$("#m_timeselect").removeClass("active");
	$("#timeselect").text("시간을 선택해주세요.");
	$("#m_timeselect").html('<a href="">시간을 선택해주세요.</a>');
	
	$('[day="' + oldSelectedDay + '"]').removeClass("dday");
	var selectedInfo = $('[day="' + day + '"]').attr("id").split("_");
	var yoilhangl = {sun:"일", mon:"월", tue:"화", wed:"수", thu:"목", fri:"금", sat:"토"}
	$("#dateTimeTxt").text(calendarData.year + "." + calendarData.month + "." + selectedInfo[2] + "(" + yoilhangl[selectedInfo[1]] + ")");		
	
	$("#timeline").html("");
	if($('[day="' + day + '"]').prop("tagName") === "A"){
		
		loading.open();
		
		$('[day="' + day + '"]').addClass("dday");
		oldSelectedDay = $('[day="' + day + '"]').attr("day");	
		rdate = calendarData.year + "-" + String(calendarData.month).lpad(2,"0") + "-" + String(selectedInfo[2]).lpad(2,"0");
		ryoil = yoilhangl[selectedInfo[1]];
		var params = {
				cpcode : "80",
				scode : "1093",
				rdate : rdate,
			}
		
		cf_call("/junohair/reservation/getReservedTime", params, initRsvTime);
	}
}

function initRsvTime(reservedTimeList){
	var cpcode = 80
	
	var amTimelineData = []
	for(var i=0; i<reservedTimeList.length; i++){
		if(reservedTimeList[i].ampm === "am"){
			amTimelineData.push(reservedTimeList[i]);
		}
	}
	
	var pmTimelineData = []
	for(var i=0; i<reservedTimeList.length; i++){
		if(reservedTimeList[i].ampm === "pm"){
			pmTimelineData.push(reservedTimeList[i]);
		}
	}
	
	var timelinehtml = "";
	timelinehtml += '<div class="timesec">';
	timelinehtml += '	<p class="tit">오전</p>';
	timelinehtml += '	<ul>';
	for(var i=0; i<amTimelineData.length; i++){
		// cpcode === 83 : 여의도IFC몰점 예약 제한 (모든 시간 예약 불가 상태)
		if(amTimelineData[i].isExist === "Y" || cpcode === 83){
			timelinehtml += '<li><span class="disabled">' + amTimelineData[i].time + '</span></li>';
		} else {
			timelinehtml += '<li><a href="#juno" time24="' + amTimelineData[i].time24 + '" ampm="am" time="' + amTimelineData[i].time + '">' + amTimelineData[i].time + '</a></li>';
		}
	}
	timelinehtml += '	</ul>';
	timelinehtml += '</div>';
	timelinehtml += '<div class="timesec">';
	timelinehtml += '	<div class="line"><span></span></div>';
	timelinehtml += '	<p class="tit">오후</p>';
	timelinehtml += '	<ul>';
	for(var i=0; i<pmTimelineData.length; i++){
		// cpcode === 83 : 여의도IFC몰점 예약 제한 (모든 시간 예약 불가 상태)
		if(pmTimelineData[i].isExist === "Y" || cpcode === 83){
			timelinehtml += '<li><span class="disabled">' + pmTimelineData[i].time + '</span></li>';
		} else {
			timelinehtml += '<li><a href="#juno" time24="' + pmTimelineData[i].time24 + '" ampm="pm" time="' + pmTimelineData[i].time + '">' + pmTimelineData[i].time + '</a></li>';
		}
	}
	timelinehtml += '	</ul>';
	timelinehtml += '</div>';
	$("#timeline").html(timelinehtml);
	
	//시간 선택시 텍스트 보여지기
	$('.timesec li a').click(function(){
		var $this = $(this);
		rtime24 = $(this).attr("time24");
		rtime = $(this).attr("time");
		rampm = $(this).attr("ampm");
		var $thistit = $this.parent().parent().siblings('.tit').text();
		var $thistxt = $this.text();
		$('.timeselect, .m_timeselect').html($thistit + ' ' +  $thistxt).addClass('active');
		$('.timesec li a').removeClass('active');
		$(this).addClass('active');
		return false;
	})

	// 모바일 시간 선택
	$('.m_timeselect').click(function(){
		$('.timeline').toggle();
		$(this).toggleClass('open');
		return false;
	});
	loading.close();	
}

var targetday = targetDateInstance.getDate();
	
function prevCal(){
	prevCalendar();
	setCalendar();
	var todayInstance = new Date();
	if(targetDateInstance.getFullYear() == todayInstance.getFullYear() && targetDateInstance.getMonth() == todayInstance.getMonth()){
		targetday = todayInstance.getDate();
	} else {
		targetday = 1;
	}
	selectDay(targetday);
}

function nextCal(){
	nextCalendar();
	setCalendar();
	var todayInstance = new Date();
	if(targetDateInstance.getFullYear() == todayInstance.getFullYear() && targetDateInstance.getMonth() == todayInstance.getMonth()){
		targetday = todayInstance.getDate();
	} else {
		targetday = 1;
	}
	selectDay(targetday);
}

function todayCal(){
	setCalendar();
	selectDay(targetday);
}

function gotoNext(){

	
	if($("#timeline").find(".active").length == 0){
		alert("시간을 선택해주세요.");
		return;
	}
	if(selectedSisullist.length == 0){
		alert("예약하실 시술을 선택해주세요.");
		return;
	}
	
	sisulIdAry = []
	for(var i=0; i<selectedSisullist.length; i++){
		sisulIdAry.push(selectedSisullist[i].id);
	}

	var params = "?sisulId=" + sisulIdAry.join() 
				+ "&orderMemo=" + encodeURIComponent($("#orderMemo").val()) 
				+ "&scode=" + "1093"
				+ "&cpcode=" + "80"
				+ "&rdate=" + rdate
				+ "&ryoil=" + encodeURIComponent(ryoil) 
				+ "&rtime24=" + rtime24
				+ "&refer=" + "norm";
	
	location.href = "/junohair/reservation/process04_confirm" + params;
}

function gotoPre(){

	

	location.href = "/junohair/reservation/process02_designer?cpcode="+"80";


	
}
</script>

</body>