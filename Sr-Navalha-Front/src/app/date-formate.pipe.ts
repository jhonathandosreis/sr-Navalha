import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'dateFormate'
})
export class DateFormatePipe implements PipeTransform {

  transform(value: any): String {
    let part1 = value.substring(0, 4);
    let part2 = value.substring(4, 7);
    let part3 = value.substring(8, 10);
    return `${part3} ${part2} ${part1}`;
  }
}
