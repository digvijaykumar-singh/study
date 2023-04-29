import { SelectionModel } from '@angular/cdk/collections';
import { MediaMatcher } from '@angular/cdk/layout';
import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { NavItem } from './nave.item';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {

  menu: NavItem [] = [
    {
      displayName: 'Admin Data Management',
      iconName: 'desktop_windows',
      route: 'admin',
      children: [
        {
          displayName: 'Leave Type Managemnet',
          iconName: 'how_to_reg',
          route: '/leave-type'
        },
        { 
          displayName: 'Employee Management',
          iconName: 'waves',
          route: '/employee'
        }
      ]
    },        
    {
      displayName: 'Leaves',
      iconName: 'description',          
      children: [
        {
          displayName: 'Apply Leave',
          iconName: 'how_to_reg',
          route: '/apply-leave'
        },
        { 
          displayName: 'Leave Balance',
          iconName: 'waves',
          route: '/leave-balance'
        }
      ]
    },
    {
      displayName: 'Profiles',
      iconName: 'group',
      children: [
          {
            displayName: 'My Profile',
            iconName: 'search',
            route: '/profile'
          }
        ]
      }
  ];
  mobileQuery: MediaQueryList;

  fillerNav = Array.from({length: 50}, (_, i) => `Nav Item ${i + 1}`);

  fillerContent = Array.from({length: 50}, () =>
      `Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut
       labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco
       laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in
       voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat
       cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.`);

  private _mobileQueryListener: () => void;

  constructor(changeDetectorRef: ChangeDetectorRef, media: MediaMatcher) {
    this.mobileQuery = media.matchMedia('(max-width: 600px)');
    this._mobileQueryListener = () => changeDetectorRef.detectChanges();
    this.mobileQuery.addListener(this._mobileQueryListener);
  }

  ngOnDestroy(): void {
    this.mobileQuery.removeListener(this._mobileQueryListener);
  }


  ngOnInit(): void {
  }

}
