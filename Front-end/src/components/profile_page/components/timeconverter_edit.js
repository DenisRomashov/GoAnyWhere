export function timeConverter2(timestamp) {

  var a = new Date(timestamp);

  var year = a.getFullYear();
  var month = editDateFormat(a.getMonth()+1);
  var date = editDateFormat(a.getDate());
  var hour = editDateFormat(a.getHours());
  var min = editDateFormat(a.getMinutes());
  var sec = editDateFormat(a.getSeconds());
  var time = year+"-"+month+"-"+date+"T"+hour+":"+min;

  return time;
}

function editDateFormat(dateItem) {
  if ((Math.floor(dateItem / 10)) === 0) {
    return "0"+dateItem
  } else {
    return dateItem
  }
}
