<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>회원 가입</title>
	
	<link rel="stylesheet" href="resources/css/agreement.css" />
</head>
<body>
	<div id="container">
		<header><a href="<c:url value='/main' />">직장IN</a></header>
		
		<form method="POST" action="#" id="agreementForm">
			<div id="selectedAllSection">
			<input type="checkbox" name="selectedAll" id="selectedAll" class="radio"/>
			<label for="selectedAll">전체 동의하기</label>
			
			<p>실명 인증된 아이디로 가입, 위치기반서비스 이용약관(선택), 이벤트・혜택 정보 수신(선택) 동의를 포함합니다. </p>
			<br />
			
			<input type="checkbox" name="termsOfUse" id="termsOfUse"/>
			<label for="termsOfUse">이용 약관</label>
			<br />
			
			<pre>
				
제 1 장 총칙


제 1 조 (목적)
본 약관은 (주) 직장IN(이하 “회사”라 합니다)이 운영하는 웹사이트 직장IN(이하 “웹사이트”라 합니다)에서 제공하는 온라인 서비스(이하 “서비스”라 한다)를 이용함에 있어 사이버몰과 이용자의 권리, 의무 및 책임사항을 규정함을 목적으로 합니다.



제 2 조 (용어의 정의)
본 약관에서 사용하는 용어는 다음과 같이 정의한다.

“웹사이트”란 회사가 재화 또는 용역을 이용자에게 제공하기 위하여 컴퓨터 등 정보통신설비를 이용하여 재화 또는 용역을 거래 할 수 있도록 설정한 가상의 영업장을 말하며, 아울러 사이버몰을 운영하는 사업자의 의미로도 사용합니다.
“이용자”란 “웹사이트”에 접속하여 서비스를 이용하는 회원 및 비회원을 말합니다.

“회원”이라 함은 “웹사이트”에 개인정보를 제공하여 회원등록을 한 자로서, “웹사이트”의 정보를 지속적으로 제공받으며, “웹사이트”이 제공하는 서비스를 계속적으로 이용할 수 있는 자를 말합니다.
“비회원”이라 함은 회원에 가입하지 않고, “웹사이트”이 제공하는 서비스를 이용하는 자를 말합니다.

“ID”라 함은 이용자가 회원가입당시 등록한 사용자 “개인이용문자”를 말합니다.

“멤버십”이라 함은 회원등록을 한 자로서, 별도의 온/오프라인 상에서 추가 서비스를 제공 받을 수 있는 회원을 말합니다.


제 3 조 (약관의 공시 및 효력과 변경)


본 약관은 회원가입 화면에 게시하여 공시하며 회사는 사정변경 및 영업상 중요한 사유가 있을 경우 약관을 변경할 수 있으며 변경된 약관은 공지사항을 통해 공시한다
본 약관 및 차후 회사사정에 따라 변경된 약관은 이용자에게 공시함으로써 효력을 발생한다.
제 4 조 (약관 외 준칙)
본 약관에 명시되지 않은 사항이 전기통신기본법, 전기통신사업법, 정보통신촉진법, ‘전자상거래등에서의 소비자 보호에 관한 법률’, ‘약관의 규제에관한법률’, ‘전자거래기본법’, ‘전자서명법’, ‘정보통신망 이용촉진등에 관한 법률’, ‘소비자보호법’ 등 기타 관계 법령에 규정되어 있을 경우에는 그 규정을 따르도록 한다.
			</pre>
			</div>
			<br />
			
			<div id="InfoCollectionSection">
			<input type="checkbox" name="InfoCollection" id="InfoCollection" class="radio"/>
			<label for="InfoCollection">개인 정보 수집 및 이용</label>
			<br />
				
			<pre>

제 2 장 이용계약


제 5 조 (이용신청)
이용신청자가 회원가입 안내에서 본 약관과 개인정보보호정책에 동의하고 등록절차(회사의 소정 양식의 가입 신청서 작성)를 거쳐 ‘확인’ 버튼을 누르면 이용신청을 할 수 있다.
이용신청자는 반드시 실명과 실제 정보를 사용해야 하며 1개의 생년월일에 대하여 1건의 이용신청을 할 수 있다.
실명이나 실제 정보를 입력하지 않은 이용자는 법적인 보호를 받을 수 없으며, 서비스 이용에 제한을 받을 수 있다.


제 6 조 (이용신청의 승낙)
회사는 제5조에 따른 이용신청자에 대하여 제2항 및 제3항의 경우를 예외로 하여 서비스 이용을 승낙한다.
회사는 아래 사항에 해당하는 경우에 그 제한사유가 해소될 때까지 승낙을 유보할 수 있다.


가. 서비스 관련 설비에 여유가 없는 경우
나. 기술상 지장이 있는 경우
다. 기타 회사 사정상 필요하다고 인정되는 경우


회사는 아래 사항에 해당하는 경우에 승낙을 하지 않을 수 있다.
가. 다른 사람의 명의를 사용하여 신청한 경우
나. 이용자 정보를 허위로 기재하여 신청한 경우
다. 사회의 안녕질서 또는 미풍양속을 저해할 목적으로 신청한 경우
라. 기타 회사가 정한 이용신청 요건이 미비한 경우
			</pre>
			</div>
			<br />
			
			<div id="adReceptionSection">
			<input type="checkbox" name="adReception" id="adReception" class="radio"/>
			<label for="adReception">[선택] 광고성 정보 수신 동의</label>
			<br />
							
			<pre>
				
주식회사 직장IN(이하 “회사”)가 운영하는 서비스에서 개인정보보호법 및 정보통신망 이용촉진 정보보호 등에 관한 법률 등 관계법령에 따라 광고성 정보를 전송하기 위해 이용자의 사전 수신 동의를 받고 있습니다. 개인정보보호법 제22조 제5항에 의해 선택정보 사항에 대해서는 기재하지 않아도 서비스를 이용하실 수 있습니다. 


1. 마케팅 및 광고에의 활용

- 신규 기능 개발 및 맞춤 서비스 제공
- 뉴스레터 발송, 새로운 기능의 안내
- 할인 및 쿠폰 등 이벤트 등의 광고성 정보 제공


2. 마케팅 정보 제공

회사는 서비스를 운용하는 과정에서 각종 정보를 푸시알림, 이메일, SMS 및 카카오 친구톡 등의 방법으로 회원에게 제공할 수 있습니다. 단, 광고성 정보 이외에 의무적으로 안내되어야 하는 정보성 내용은 수신동의 여부와 무관하게 제공합니다.


3. 수신 동의 및 철회

수신 동의 이후에도 의사에 따라 동의를 철회할 수 있으며, 수신을 동의하지 않아도 회사에서 제공하는 기본적인 서비스를 이용할 수 있으나 회사가 제공하는 마케팅 정보를 수신하지 못할 수 있습니다. 
고객이 본 수신 동의를 철회하고자 할 경우 앱내 알림 설정 또는 고객센터를 통하여 수신 동의 철회를 요청할 수 있습니다. 
또한 향후 마케팅정보 수신에 새롭게 동의하고자 할 경우 앱내 알림 설정에서 동의하실 수 있습니다.
			</pre>
			</div>
			<br />

			
			<input type="submit" value="다음" id="submitBtn"/>
		</form>
	</div>
</body>
</html>