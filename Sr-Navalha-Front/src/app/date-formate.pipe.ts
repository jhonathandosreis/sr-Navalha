import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'dateFormate'
})
export class DateFormatePipe implements PipeTransform {

  transform(value: Date): String {
    let latest_date = new Date(value).toString();
    let part1 = latest_date.substring(0, 4);
    let part2 = latest_date.substring(4, 6);
    let part3 = latest_date.substring(6, 8);
    return `(${part3})/ ${part2} /${part1}`;
  }
}
