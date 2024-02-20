import React from "react";
import { Link } from "react-router-dom";
import styled from "styled-components";
import { useState } from "react";
import axios from "axios";

const CardBookContainer = styled.div`
  display: flex;
`;

const ImageField = styled.img`
  width: 132px;
  height: 191.5px;
  margin-top: 80px;
  border-bottom: #007af3 1px solid;
  border-top: #007af3 1px solid;
  border-left: #007af3 1px solid;
`;

const ButtonField = styled.div`
  padding: 20px;
  display: flex;
  flex-direction: column;
  width: 188px;
  height: 151.5px;
  border-radius: 0px 4px 4px 0px;
  border: #007af3 1px solid;
  margin-top: 80px;
`;

const CardBook = ({ data, cardbookId, imageUrl, user }) => {
  const [isEditing, setIsEditing] = useState(false);
  const [name, setName] = useState(data.name);

  const handleEdit = () => {
    if (isEditing) {
      const data = {
        name: name,
        cardbookId: cardbookId,
      };

      axios
        .put(`${import.meta.env.VITE_API_KEY}/cardbook/`, data)
        .then((response) => {
          console.log("수정 완료!");
        })
        .catch((error) => {
          console.error("수정 실패:", error.response);
        });
    }
    setIsEditing(!isEditing);
  };

  const handleDelete = () => {
    fetch(`${import.meta.env.VITE_API_KEY}/cardbook/${cardbookId}`, {
      method: "DELETE",
    })
      .then((response) => response.json())
      .then((data) => {
        console.log("삭제 요청이 완료되었습니다.", data);
        alert("삭제가 완료되었습니다.");
        window.location.reload(); // 페이지 새로고침
      })
      .catch((error) => {
        console.error("삭제 요청 중 오류가 발생했습니다.", error);
      });
  };

  let bookImage;

  bookImage = import.meta.env.VITE_API_KEY + imageUrl;

  return (
    <CardBookContainer>
      <Link to={`/cardbook/${cardbookId}/themes`}>
        <ImageField src={bookImage} alt="book cover" />
      </Link>
      <ButtonField onClick={(e) => e.stopPropagation()}>
        {isEditing ? (
          <input value={name} onChange={(e) => setName(e.target.value)} />
        ) : (
          <div style={{ color: "#007af3", fontSize: 17 }}>{name}</div>
        )}
        <div style={{ marginTop: 10, fontSize: 17 }}>{data.writer}</div>
        <div style={{ marginTop: 30, fontSize: 17 }}>{data.updateDate}</div>
        {user === "사용자" && (
          <div style={{ marginTop: 50, fontSize: 17 }}>
            <button onClick={handleEdit}>{isEditing ? "저장" : "수정"}</button>{" "}
            | <button onClick={handleDelete}> 삭제</button>
          </div>
        )}
      </ButtonField>
    </CardBookContainer>
  );
};

export default CardBook;
