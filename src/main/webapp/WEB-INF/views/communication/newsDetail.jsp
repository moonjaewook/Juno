<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" class=" js no-touch csstransforms csstransforms3d csstransitions" style=""><head>

<link rel="shortcut icon" href="https://www.junohair.com/static_resources/images/junohair.ico">
<link rel="apple-touch-icon" href="https://www.junohair.com/static_resources/images/apple-touch-icon.png">
<link rel="apple-touch-icon-precomposed" href="https://www.junohair.com/static_resources/images/apple-touch-icon.png">
<link rel="canonical" href="https://www.junohair.com/junohair">

	<!-- Global site tag (gtag.js) - Google Analytics -->
<script type="text/javascript" async="" src="https://www.google-analytics.com/analytics.js"></script><script type="text/javascript" async="" src="https://www.googletagmanager.com/gtag/js?id=G-DBGPMGH101&amp;l=dataLayer&amp;cx=c"></script><script async="" src="https://www.googletagmanager.com/gtag/js?id=UA-150219424-1"></script>
<script>
/*
  window.dataLayer = window.dataLayer || [];
  function gtag(){dataLayer.push(arguments);}
  gtag('js', new Date());

  gtag('config', 'UA-150219424-1');
*/
</script>
<script type="text/javascript" src="//wcs.naver.net/wcslog.js"></script>
<script type="text/javascript">
/*
if(!wcs_add) var wcs_add = {};
wcs_add["wa"] = "fce44f52888e1";
if(window.wcs) {
wcs_do();
}
*/
</script>
<title>준오헤어</title>
<link rel="stylesheet" href="https://www.junohair.com/static_resources/css/reset.css?rscVer=0333">
<link rel="stylesheet" href="https://www.junohair.com/static_resources/css/owl.carousel.css?rscVer=0333">
<link rel="stylesheet" href="https://www.junohair.com/static_resources/css/common.css?rscVer=0333">
<link rel="stylesheet" href="https://www.junohair.com/static_resources/css/junohair/common.css?rscVer=0333">
<link rel="stylesheet" href="https://www.junohair.com/static_resources/css/junohair/sub_common.css?rscVer=0333">
<link rel="stylesheet" href="https://www.junohair.com/static_resources/css/junohair/sub_style4.css?rscVer=0333">
<script src="https://www.junohair.com/static_resources/lib/jquery/1.12.4/jquery.min.js?rscVer=0333"></script>
<script src="https://www.junohair.com/static_resources/js/owl.carousel.min.js?rscVer=0333"></script>
<script src="https://www.junohair.com/static_resources/js/imagesloaded.3.2.x.pkgd.min.js?rscVer=0333"></script>
<script src="https://www.junohair.com/static_resources/js/isotope.min.js?rscVer=0333"></script>
<script src="https://www.junohair.com/static_resources/js/viewportchecker.js?rscVer=0333"></script>
<script src="https://www.junohair.com/static_resources/js/modernizr.js?rscVer=0333"></script>
<script src="https://www.junohair.com/static_resources/js/smoothscroll.js?rscVer=0333"></script>

<link rel="stylesheet" href="https://www.junohair.com/static_resources/css/contents.display.none.css?rscVer=0333">
<script src="https://www.junohair.com/static_resources/lib/vue/2.6.10/vue.min.js?rscVer=0333"></script>
<script src="https://www.junohair.com/static_resources/lib/vue-the-mask/vue-the-mask.js?rscVer=0333"></script>
<script src="https://www.junohair.com/static_resources/lib/babel-polyfill/7.4.4/polyfill.min.js?rscVer=0333"></script>
<script src="https://www.junohair.com/static_resources/lib/axios/0.19.0/axios.min.js?rscVer=0333"></script>
<script src="https://www.junohair.com/static_resources/js/common.js?rscVer=0333"></script>
<script src="https://www.junohair.com/static_resources/js/common_vue.js?rscVer=0333"></script>

<script src="https://www.junohair.com/static_resources/js/junohair/juno_sub_ui.js?rscVer=0333"></script>
</head>
<body>
	<div id="wrap">
		
		<div id="header" class="">
			<div class="header_top">
				<span class="logo"><a href="#juno" onclick="location.href='/'"><img src="https://www.junohair.com/static_resources/images/home_icon.png" alt="JUNO"></a></span>
				<div class="inner">
					<div id="gnb">
						<ul>
							<li class="active"><a href="#juno" onclick="location.href='/junohair'">JUNO HAIR</a></li>
							<li><a href="#juno" onclick="location.href='/junoacademy'">JUNO ACADEMY</a></li>
							<li><a href="#juno" onclick="location.href='/avenuejuno'">AVENUE JUNO</a></li>
							<li><a href="#juno" onclick="location.href='/recruit'">RECRUIT</a></li>
							<li><a href="#juno" onclick="gotoMyjuno()">MY JUNO</a></li>
						</ul>
					</div>
				</div>
				
				<div class="util">
					<dl>
						<dt class="hide">유틸메뉴</dt>

						<dd class="login"><a href="#juno" onclick="location.href='/myjuno/login'"><span>로그인</span><img src="https://www.junohair.com/static_resources/images/logout_icon.png" alt="로그인"></a></dd>

					</dl>
				</div>
				<div class="lang">
					<a href="#juno" onclick="lang_toggle()" class="cur_lang"><img src="https://www.junohair.com/static_resources/images/kr_n.png" alt="국가 아이콘" class="national">한국어</a>
					<span class="lang_arr arr_down"><img src="https://www.junohair.com/static_resources/images/lang_arr_down.png" alt=""></span>
					<span class="lang_arr arr_up"><img src="https://www.junohair.com/static_resources/images/lang_arr_up.png" alt=""></span>
					<ul class="lang_list">
						<li><a href="#juno" onclick="location.href='/en/junohair'"><img src="https://www.junohair.com/static_resources/images/en_n.png" alt="국가 아이콘" class="national">ENG</a></li>
						<li><a href="#juno" onclick="location.href='/cn/junohair'"><img src="https://www.junohair.com/static_resources/images/cn_n.png" alt="국가 아이콘" class="national">中國語</a></li>
					</ul>
				</div>
			</div>
			<div class="header_btm">
				<div class="inner">
					<h1>
						<a href="/junohair">
							<img src="https://www.junohair.com/static_resources/images/junohair/junohair_logo_dark.png" alt="JUNO HAIR" class="dark">
							<img src="https://www.junohair.com/static_resources/images/junohair/junohair_logo_light.png" alt="JUNO HAIR" class="light">
						</a>
					</h1>
					<div class="lnb">
						<ul>
							<li><a href="#juno" onclick="location.href='/junohair/about/story'">ABOUT</a></li>
							<li><a href="#juno" onclick="location.href='/junohair/salon/shop_list'">SALON</a></li>
							<li><a href="#juno" onclick="location.href='/junohair/membership/policy'">MEMBERSHIP</a></li>
							<li><a href="#juno" onclick="location.href='/junohair/communication/news_list'">COMMUNICATION</a></li>
							<li><a href="#juno" onclick="location.href='/junohair/reservation/intro'">RESERVATION</a></li>
							<li><a href="#juno" onclick="location.href='/junohair/jmarket/prodlist'">J MARKET</a></li>
						</ul>
					</div>
					<div class="mobile_menu_btn">
						<a href="#juno" onclick="m_nav();">
							<span></span>
							<span></span>
							<span></span>
						</a>
					</div>
				</div>
			</div>
		</div>
		<div class="mobile_nav" style="display: none;">
			<div class="mobile_nav_inner">
				<div class="m_util">
					<ul>

						<li><a href="#juno" onclick="location.href='/myjuno/login'">로그인</a></li>
						<li><a href="#juno" onclick="location.href='/myjuno/join_polish'">회원가입</a></li>
	
					</ul>
				</div>
				<div class="mn_wrap">
					<div class="lnb">
						<ul>
							<li>
								<strong class="depth1">ABOUT<div><span class="horizon"></span><span class="vertical"></span></div></strong>
								<dl>
									<dt class="hide">ABOUT</dt>
									<dd><a href="#juno" onclick="location.href='/junohair/about/story'">스토리</a></dd>
									<dd><a href="#juno" onclick="location.href='/junohair/about/ceo'">CEO 인사말</a></dd>
									<dd><a href="#juno" onclick="location.href='/junohair/about/brand'">브랜드</a></dd>
									<dd><a href="#juno" onclick="location.href='/junohair/about/location'">오시는길</a></dd>
								</dl>
							</li>
							<li>
								<strong class="depth1">SALON<div><span class="horizon"></span><span class="vertical"></span></div></strong>
								<dl>
									<dt class="hide">SALON</dt>
									<dd><a href="#juno" onclick="location.href='/junohair/salon/shop_list'">살롱 소개</a></dd>

								</dl>
							</li>
							<li>
								<strong class="depth1">MEMBERSHIP<div><span class="horizon"></span><span class="vertical"></span></div></strong>
								<dl>
									<dt class="hide">MEMBERSHIP</dt>
									<dd><a href="#juno" onclick="location.href='/junohair/membership/policy'">멤버십 제도</a></dd>
									<dd><a href="#juno" onclick="location.href='/junohair/membership/partnercard'">제휴 할인 카드</a></dd>
									<dd><a href="#juno" onclick="location.href='/junohair/membership/mobilecoupon'">모바일 쿠폰</a></dd>
								</dl>
							</li>
							<li>
								<strong class="depth1">COMMUNICATION<div><span class="horizon"></span><span class="vertical"></span></div></strong>
								<dl>
									<dt class="hide">COMMUNICATION</dt>
									<dd><a href="#juno" onclick="location.href='/junohair/communication/news_list'">NEWS</a></dd>
									<dd><a href="#juno" onclick="location.href='/junohair/communication/qna'">Q&amp;A</a></dd>
									<dd><a href="#juno" onclick="location.href='/junohair/communication/partnership'">제휴문의</a></dd>
								</dl>
							</li>
							<li>
								<strong class="depth1"><a href="#juno" onclick="location.href='/junohair/reservation/intro'">RESERVATION</a></strong>
							</li>
							<li>
								<strong class="depth1"><a href="#juno" onclick="location.href='/junohair/jmarket/prodlist'">J MARKET</a></strong>
							</li>
							<li>
							</li><li>
								<strong class="depth1">MY JUNO<div><span class="horizon"></span><span class="vertical"></span></div></strong>
								<dl>
									<dt class="hide">MY JUNO</dt>
									<dd><a href="#juno" onclick="gotoMyjunoMbr()">회원정보</a></dd>
									<dd><a href="#juno" onclick="gotoMyjunoUL()">이용내역</a></dd>
									<dd><a href="#juno" onclick="gotoMyjunoOL()">구매내역</a></dd>
									<dd><a href="#juno" onclick="gotoMyjunoSS()">정기배송 설정</a></dd>
									<dd><a href="#juno" onclick="gotoMyjunoWD()">회원 탈퇴</a></dd>
								</dl>
							</li>
						</ul>
					</div>
					<div class="gnb">
						<ul>
							<li><a href="#juno" onclick="location.href='/junohair'"><img class="hair" src="https://www.junohair.com/static_resources/images/m_gnb_hair.png" alt="JUNO HAIR"></a></li>
							<li><a href="#juno" onclick="location.href='/junoacademy'"><img class="academy" src="https://www.junohair.com/static_resources/images/m_gnb_academy.png" alt="JUNO ACADEMY"></a></li>
							<li><a href="#juno" onclick="location.href='/avenuejuno'"><img class="avenue" src="https://www.junohair.com/static_resources/images/m_gnb_avenue.png" alt="AVENUE JUNO"></a></li>
							<li><a href="#juno" onclick="location.href='https://www.triamilia.com/'"><img class="tria" src="https://www.junohair.com/static_resources/images/m_gnb_tria.png" alt="TRIA MILIA"></a></li>
							<li><a href="#juno" onclick="location.href='/recruit'">RECRUIT</a></li>
							<li><a href="#juno" onclick="location.href='/en/junohair/'">ENGLISH</a></li>
							<li><a href="#juno" onclick="location.href='/cn/junohair/'">中国</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<script>
		/*
		function gotoMyjuno(){
			if("" != "CUST"){
				alert("로그인후 이용이 가능합니다.");
			}
			location.href = "/myjuno/member_info";
		}
		
		function gotoMyjunoMbr(){
			if("" != "CUST"){
				alert("로그인후 이용이 가능합니다.");
			}
			location.href = "/myjuno/member_info";
		}
		
		function gotoMyjunoUL(){
			if("" != "CUST"){
				alert("로그인후 이용이 가능합니다.");
			}
			location.href = "/myjuno/use_list";
		}
		
		function gotoMyjunoOL(){
			if("" != "CUST"){
				alert("로그인후 이용이 가능합니다.");
			}
			location.href = "/myjuno/order_list";
		}
		
		function gotoMyjunoSS(){
			if("" != "CUST"){
				alert("로그인후 이용이 가능합니다.");
			}
			location.href = "/myjuno/sdelivery_set";
		}
		
		function gotoMyjunoWD(){
			if("" != "CUST"){
				alert("로그인후 이용이 가능합니다.");
			}
			location.href = "/myjuno/withdraw";
		}
		*/
		</script>
		<div id="container">

			<div class="sub_visual">
				<div class="sub_visual_bg" style="background-image:url(https://www.junohair.com/static_resources/images/junohair/sub/community/intro_visual2.jpg)"></div>
				<div class="sub_visual_text">
					<strong>COMMUNICATION</strong>
					<p class="sub_visual_sub_text">
						<span>고객과의 소통을 최우선으로 <br class="m">생각하는 준오헤어는</span><br>
						<span>다양한 방법으로 고객의 소리를 듣겠습니다</span>
					</p>
				</div>
			</div>
			<div class="sub_menu w33p">
				<div class="inner">
					<ul>
						<li class="cur"><strong><a href="#juno" onclick="location.href='news_list'">NEWS</a></strong></li>
						<li><strong><a href="#juno" onclick="location.href='qna'">Q&amp;A</a></strong></li>
						<li><strong><a href="#juno" onclick="location.href='partnership'">제휴문의</a></strong></li>
					</ul>
				</div>
			</div>
			<div class="clear"></div>

			
			<div id="contents" class="praise">
				<div class="section section1">
					<div class="inner">
						<div class="section_tit">
							<span class="bar"></span>
							<strong class="tit">NEWS</strong>
						</div>
						<div class="section_content fadeInUp hidden">
							<div class="news_view">
								<div class="head">
									<h2 class="subj">${notice.title}</h2>
									<div class="info">
										<span class="cate">
											<c:choose>
				                                <c:when test="${notice.contentType == 1}">News</c:when>
				                                <c:when test="${notice.contentType == 2}">Notice</c:when>
				                                <c:otherwise>Etc</c:otherwise>
				                            </c:choose>
										</span>
										<span class="date">${notice.created_at}</span>
									</div>
								</div>
								<div class="edit">
									<div style="text-align: center;"><img src="./resources/noticenews/${notice.contentImage}" alt="" style="font-size: 13px;"></div><p style="text-align: center; "></p>
								</div>
								<!-- 
								<div class="news_footnav">
									<ul>
										<li>
											<a href="#juno" onclick="location.href='/junohair/communication/news_view?idx=31'" class="prev">
												<span class="tit">이전글</span>
												<span class="subj">2024 썸머 이벤트</span>
												<span class="date">2024-06-20</span>
											</a>
										</li>
									</ul>
								</div>
								 -->
								<div class="btn_bottom">
									<a href="./news" class="btnbox_black">목록보기</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<div id="footer">
			<div class="footgotop" id="goTop"><a href="#juno" onclick="goTopbtn()"><span class="blind">상단으로 가기</span></a></div>
			<div class="footer_top">
				<div class="inner">
					<div class="ft_left">
						<div class="family_site">
							<img src="https://www.junohair.com/static_resources/images/family_site.png" alt="family site">
							<span class="bar"></span>
							<ul class="fs_list">
								<li><a href="#juno" onclick="location.href='/junohair'"><img src="https://www.junohair.com/static_resources/images/family_junoHair.png" alt="JUNO HAIR"></a></li>
								<li><a href="#juno" onclick="location.href='/junoacademy'"><img src="https://www.junohair.com/static_resources/images/family_junoAcademy.png" alt="JUNO ACADEMY"></a></li>
								<li><a href="#juno" onclick="location.href='/avenuejuno'"><img src="https://www.junohair.com/static_resources/images/family_junoAvenue.png" alt="JUNO AVENUE"></a></li>
								<li><a href="#juno" onclick="location.href='https://www.triamilia.com/'"><img src="https://www.junohair.com/static_resources/images/family_triamilia.png" alt="triamilia"></a></li> 
							</ul>
						</div>
						<div class="terms">
							<ul class="term_list">
								<li><a href="#juno" onclick="window.open('/myjuno/privacypolicy?section=1', '_blank');">이용약관</a></li>
								<li><span class="bar"></span></li>
								<li><a href="#juno" onclick="window.open('/myjuno/privacypolicy?section=2', '_blank');">개인정보처리방침</a></li>
							</ul>
						</div>
					</div>
					<div class="ft_right">
						<div class="ft_rightTop">
							<ul>
								<li><a href="#juno" onclick="location.href='/junohair/communication/partnership'">제휴문의</a></li>
								<li><a href="#juno" onclick="location.href='/recruit'">인재채용</a></li>
								<li><a href="#juno" onclick="location.href='/junohair/communication/qna'">Q&amp;A</a></li>
							</ul>
						</div>
						<div class="fr_rightBottom">
							<strong><img src="https://www.junohair.com/static_resources/images/junohair/footer_media_img.png" alt="JUNO SOCIAL MEDIA"><span class="bar"></span></strong>
							<ul>
								<li><a href="#juno" onclick="window.open('https://www.facebook.com/junohair.official/', '_blank');"><img src="https://www.junohair.com/static_resources/images/junohair/footer_social1.jpg" alt="facebook"></a></li>
								<li><a href="#juno" onclick="window.open('https://www.instagram.com/junohair_official/', '_blank');"><img src="https://www.junohair.com/static_resources/images/junohair/footer_social2.jpg" alt="instagram"></a></li>
								<li><a href="#juno" onclick="window.open('https://www.youtube.com/channel/UCwmPMC_aCMskDKR6P30pn6Q/', '_blank');"><img src="https://www.junohair.com/static_resources/images/junohair/footer_social_youtube.jpg" alt="youtube"></a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
			<div class="footer_btm">
				<div class="inner">
					<strong><img src="https://www.junohair.com/static_resources/images/junohair/footer_junohair_logo.png" alt="JUNO HAIR"></strong>
					<div class="address">
						<p>
							<span>(주)준오뷰티</span>
							<span>대표자 강윤선</span>	
							<span>서울특별시 강남구 청담동 63-14 JUNO &amp; BEAUTY 5층</span>	
						</p>
						<p>
							<span>사업자등록번호 : 110-81-60003</span>
							<span>통신판매번호 : 2020-서울강남-02683호</span>
							<span>대표전화 +82-2-548-0605</span>
						</p>
						<p>Copyright ⓒ 2017 JUNOHAIR.COM. All rights Reserved.</p>
					</div>
		            <div class="emblem">
		            	<img src="https://www.junohair.com/static_resources/images/K_BPI_2020.png" alt="2020 K-BPI 파워엠블렘" style="height:44px">  <!-- 2020-04-02 이미지경로 수정-->
						<img src="https://www.junohair.com/static_resources/images/naward.png" alt="2017 &amp;Award">
		            </div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>