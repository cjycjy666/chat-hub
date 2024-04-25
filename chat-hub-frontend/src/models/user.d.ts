/**
 * 用户类别
 */
export type Usertype = {
    id: number;
    username: string;
    userAccount: string;
    avatarUrl: string;
    gender: number;
    phone: string;
    email: string;
    tags: string[];
    userStatus: number;
    userRole: number;
    createTime: Date;
}