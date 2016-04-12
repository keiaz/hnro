/**
 * js 공통유틸
 */

/**
 * 마지막 자리수에서 1을 증가시킨다. 23 > 24, -22 > -21, 0.03 > 0.04
 * @param {Number} num
 * @see {@link numberToString}
 * @returns {Number}
 */
function autoIncrement(num) {
	var strNum, pointIndex, pow, incNum;
	
	strNum = numberToString(num);
	pointIndex = strNum.lastIndexOf(".");
	
	if (pointIndex !== -1) {
		pow = strNum.length - pointIndex - 1;
		incNum = num + (1 / Math.pow(10, pow));
	} else {
		incNum = num + 1;
	}
	
	return incNum;
}

/**
 * 숫자를 문자열로 변경한다. 지수값으로 표현되는 수치값도 숫자로 표현한다.
 * @param {Number} num 변경할 수치값
 * @returns {String}
 */
function numberToString(num) {
	var e;
	
	if (Math.abs(num) < 1.0) {
		e = parseInt(num.toString().split('e-')[1]);
		if (e) {
			num *= Math.pow(10, e - 1);
			num = '0.' + (new Array(e)).join('0') + num.toString().substring(2);
		}
	} else {
		e = parseInt(num.toString().split('+')[1]);
		if (e > 20) {
			e -= 20;
			num /= Math.pow(10, e);
			num += (new Array(e + 1)).join('0');
		}
	}
	
	return num + "";
}
