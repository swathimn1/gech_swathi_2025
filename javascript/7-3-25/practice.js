document.getRootNode();
const document_root=document.getRootNode();
console.log(document_root);
console.log(document_root.childNodes)

const document_type=document_root.childNodes[0];
console.log(document_type);

const html_tag=document_root.childNodes[1];
console.log(html_tag);
console.log(html_tag.childNodes);

const head_tag=html_tag.childNodes[0];
console.log(head_tag);
console.log(head_tag.childNodes);
console.log(head_tag.childNodes[0]);

title_tag=head_tag.childNodes[1];
console.log(title_tag);
console.log(title_tag.innerText);
console.log(title_tag.textContent);
console.log(title_tag.innerHTML);
console.log(title_tag.parentNode);
console.log(title_tag.nextSibling);
console.log(title_tag.nextElementSibling);

console.log(head_tag.childNodes[2]);
console.log(head_tag.childNodes[3]);
console.log(head_tag.childNodes[4]);
console.log(head_tag.childNodes[5]);
console.log(head_tag.childNodes[6]);


console.log(html_tag.childNodes[1]);
const  body_tag=html_tag.childNodes[2];
console.log(body_tag);
console.log(body_tag.childNodes);
console.log(body_tag.childNodes[0]);

const div_tag=body_tag.childNodes[1];
console.log(div_tag);
console.log(div_tag.innerText);
console.log(div_tag.innerHTML);
console.log(div_tag.textContent);
console.log(div_tag.parentNode);
console.log(div_tag.nextSibling);
console.log(div_tag.nextElementSibling);

// console.log(div_tag.childNodes[0]);
// console.log(div_tag.childNodes[1]);

console.log(body_tag.childNodes[2]);

script_tag=body_tag.childNodes[3];
console.log(script_tag);
console.log(body_tag.childNodes[4]);
// console.log(body_tag.childNodes[4].innerText);
// console.log(body_tag.childNodes[4].innerHTML);
// console.log(body_tag.childNodes[4].textContent);

console.log(body_tag.childNodes[5]);
console.log(body_tag.childNodes[6]);
console.log(body_tag.childNodes[7]);
console.log(body_tag.childNodes[8]);

console.log(div_tag);
console.log(div_tag.childNodes);
console.log(div_tag.childNodes[0]);
console.log(div_tag.childNodes[1]);
console.log(div_tag.childNodes[1].innerText);
console.log(div_tag.childNodes[2]);
console.log(div_tag.childNodes[3]);
console.log(div_tag.childNodes[3].innerText);
console.log(div_tag.childNodes[4]);
















