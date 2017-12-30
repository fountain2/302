function AtTrim(s) {
    var r1, r2, s1, s2, s3;
    r1 = new RegExp("^ *");
    r2 = new RegExp(" *$");
    s1 = ""+s+"";
    s2 = s1.replace(r1, "");
    s3 = s2.replace(r2, "");
    r1 = null;
    r2 = null; 
    return(s3); 
}

function isValidEmail(str) {
    str=AtTrim(str);
    var apos = str.indexOf("@");
    var dpos = str.lastIndexOf(".");
    var spos = str.indexOf(" ");
    var cpos = str.indexOf(",");
    if (cpos>=0 || spos>=0 || apos<=0 || dpos<=0)
         return false;
    if(dpos<=apos+1) return false;
    if(str.charAt(apos+1) == '.') return false;
    if(str.charAt(str.length-1) == '.') return false;
    return true;
}

function isValidNumber(strInteger) {
    var i;
    var c;
    for (i = 0; i< strInteger.length; i++) {
        c = strInteger.charAt(i);
        if ((c>'9' || c<'0') && (c!='-')) {
            return false;
            break;
        }
    }
    if (i<1)
        return false;
    return true;
}
function isValidPID(strInteger) {
    var i;
    var c;
    for (i = 0; i< strInteger.length; i++) {
        c = strInteger.charAt(i);
        if ((c>'9' || c<'0') && (c!='x')) {
            return false;
            break;
        }
    }
    if ((i == 15) || (i==18) || (i==0))
     return true;
    return false;
}

function isValidpostID(strInteger) {
    var i;
    var c;
    for (i = 0; i< strInteger.length; i++) {
        c = strInteger.charAt(i);
        if ((c>'9' || c<'0')) {
            return false;
            break;
        }
    }
    if (i!=6)
        return false;
    return true;
}
String.prototype.trim = function() {
	return this.replace(/(^\s+)|(\s+$)/g, "");
};
String.prototype.capitalize = function() {
	return this.charAt(0).toUpperCase() + this.substring(1).toLowerCase();
}