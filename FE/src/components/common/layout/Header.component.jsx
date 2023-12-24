import React from "react";
import styled from "styled-components";
import { Icon } from "../Icon.component";

const Header = () => {
  return (
    <div>
      <HeaderArea>
        <Inner>
          <a href="/">
            <Logo src="logo.png" alt="logo" />
          </a>

          <Submenu>
            <Menu>
              <li>
                <A href="#">망각 곡선이란?</A>
              </li>
              <li>
                <A href="#">뤼뤼 사용법</A>
              </li>
              <li>
                <A href="#">내 정보</A>
              </li>
            </Menu>
            <Search>
              <Input type="text" />
              <Icon type="search" />
            </Search>
            <Button>로그인</Button>
            <Button>회원가입</Button>
          </Submenu>
        </Inner>
      </HeaderArea>
    </div>
  );
};

export default Header;

const HeaderArea = styled.header`
  position: relative;
  width: 100%;
  height: 5rem;
  border-bottom: 0.08375rem solid #ccc;
`;

const Logo = styled.img`
  position: absolute;
  top: 0;
  bottom: 0;
  margin: auto 0;
  width: 8.125rem;
  display: block;
`;

const Inner = styled.div`
  position: relative;
  width: 83.125rem; /* 1330px를 rem으로 변환한 값 */
  height: 5rem; /* 70px를 rem으로 변환한 값 */
  margin: 0 auto;
`;

const A = styled.a`
  display: block;
  padding: 0.6875rem 1rem;
  font-size: 1.0625rem;
  text-decoration: none;

  &:hover {
    color: #007af3;
  }
`;

const Menu = styled.ul`
  display: flex;
  list-style: none;
  top: 0;
  bottom: 0;
  margin: auto 0 auto 6.5rem;
`;

const Search = styled.div`
  position: relative;
  height: 2.1875rem;
  margin: auto 0 auto 30.625rem; /* 490px를 rem으로 변환한 값 */
`;

const Input = styled.input`
  width: 12.375rem; /* 198px를 rem으로 변환한 값 */
  height: 2.1875rem;
  padding: 0.25rem 0.625rem;
  border: 0.0625rem solid #ccc;
  background-color: #ececec;
  box-sizing: border-box;
  border-radius: 0.3125rem; /* 5px를 rem으로 변환한 값 */
  outline: none;
  position: relative;
`;
const Button = styled.button`
  height: 2.1875rem;
  position: relative;
  margin: auto 0 auto 0.625rem; /* 10px를 rem으로 변환한 값 */
  padding: 0 0.5725rem;
  font-size: 1.0625rem;
  background-color: #fff;
  border: 0.0625rem solid #bbb;
  border-radius: 0.3125rem; /* 5px를 rem으로 변환한 값 */
`;

const Submenu = styled.div`
  display: flex;
  top: 0;
  bottom: 0;
  margin: auto 0;
  position: absolute;
  height: 5rem;
`;
