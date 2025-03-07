//console.log("hello")
//console.log(document.getRootNode());
const  document_root=document.getRootNode();
console.log(document_root.childNodes);

const html_tag=document_root.childNodes[1];
console.log(html_tag);
console.log(html_tag.childNodes);

const head_tag=html_tag.childNodes[0];
console.log(head_tag.childNodes);
console.log(head_tag.children);

const title_tag=head_tag.childNodes[0];
console.log(title_tag.innerText);
console.log(title_tag.innerHTML);
console.log(title_tag.textContent);
console.log(title_tag.parentNode);
console.log(title_tag.nextSibling);
console.log(title_tag.nextElementSibling);

//const body_tag=html_tag.childNodes[2];
const body_tag=document.body;
console.log(body_tag);
console.log(body_tag.childNodes);
console.log(body_tag.children);

const div_tag=body_tag.children[0];
console.log(div_tag);
console.log(div_tag.childNodes);
console.log(div_tag.children);

const container=div_tag.children[0];
console.log(container);
console.log(container.childNodes);
// console.log(container.children);

const h1_tag=div_tag.children[0];
console.log(h1_tag);
console.log(h1_tag.innerText);

const p_tag=div_tag.children[1];
console.log(p_tag);
console.log(p_tag.textContent);

const script_tag=body_tag.children[1];
console.log(script_tag);
console.log(script_tag.innerText);
console.log(script_tag.nextElementSibling);