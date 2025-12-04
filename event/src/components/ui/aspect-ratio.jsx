import React from "react";
import { AspectRatio } from "./AspectRatio"; // adjust path if needed

function ImageCard() {
  return (
    <AspectRatio ratio={16 / 9} className="bg-gray-200 rounded-lg overflow-hidden">
      <img
        src="https://via.placeholder.com/800x450"
        alt="Sample"
        className="object-cover w-full h-full"
      />
    </AspectRatio>
  );
}

export default ImageCard;