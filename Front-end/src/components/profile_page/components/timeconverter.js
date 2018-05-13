export function timeConverter(timestamp) {

  var a = new Date(timestamp);
  var months = ['Jan','Feb','Mar','Apr','May','Jun','Jul','Aug','Sep','Oct','Nov','Dec'];
  var year = a.getFullYear();
  var month = months[a.getMonth()];
  var date = a.getDate();
  var hour = a.getHours();
  var min = a.getMinutes();
  var sec = a.getSeconds();
    if (min === 0) {
         min += "0";
       }
  var time = date + ' ' + month + ' ' + year + ' ' + hour + ':' + min;
  return time;
}
